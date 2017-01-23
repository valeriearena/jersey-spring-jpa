package com.heartbeat.clientApi;

import com.heartbeat.clientApi.enums.PermissionKeyEnum;
import com.heartbeat.clientApi.util.AccessControlUtil;
import com.heartbeat.clientApi.vo.InjectedRequestData;
import com.heartbeat.clientApi.vo.InjectedRequestDataFactory;
import org.glassfish.jersey.message.internal.ReaderWriter;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;

/**
 * Created by michaelkellstrand on 11/22/16.
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter
{

    private static final String AUTH_BEARER_PREFIX = "Bearer ";

    private static final String CLINICAL_PATH_PREFIX = "clinical";
    private static final String INIT_SERVICE_PATH = "clinical/init";


    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {

        // Check if system is available (down for maintenance, etc.)
        if (false  /* TODO: system down for maintenance */) {

            /*
                        if (SystemUpdate.isDownForMaintenance()) {
                message = MHMessageResources.getFormattedMessage("server.systemupdate.down_maintenance");
                responseExtraVo = new ClientResponseExtraVO(SystemKeyEnum.downForMaintenance.getDescription());
            }
             */

            requestContext.abortWith(Response.serverError().build());
            return;
        }

        // Get URI path and continue on if not a secure service path
        String servicePath = requestContext.getUriInfo().getPath();
        if (servicePath == null || !servicePath.startsWith(CLINICAL_PATH_PREFIX))
        {
            return;
        }

        // Authenticate access token and obtain its associated user info
        InjectedRequestData injectedRequestData = authenticate(requestContext);
        if (injectedRequestData == null) {

            requestContext.abortWith(Response.serverError().build());
            return;
        }

        // Verify the user has initialized or is calling the initialize service
        if (!injectedRequestData.isInitialized() && !servicePath.startsWith(INIT_SERVICE_PATH))
        {

            requestContext.abortWith(Response.serverError().build());
            return;
        }

        // Validate payload checksum
        if (!isChecksumValid(requestContext)) {
            requestContext.abortWith(Response.serverError().build());
            return;
        }

        // Add extra injected data to request
        requestContext.setProperty(InjectedRequestDataFactory.INJECTED_REQUEST_DATA_PROPERTY, injectedRequestData);

        // Add security context to request
        requestContext.setSecurityContext(new MHBSecurityContext(requestContext, injectedRequestData.getUsername()));
    }


    private InjectedRequestData authenticate(final ContainerRequestContext requestContext) {

        // Get the authorization header
//        String authHeader = requestContext.getHeaderString("authorization");
//        if (authHeader == null || !authHeader.startsWith(AUTH_BEARER_PREFIX))
//        {
//            return null;
//        }

        return new InjectedRequestData(true, "val", true);
    }


    private boolean isChecksumValid(ContainerRequestContext requestContext)
    {
        try (ByteArrayOutputStream outStream = new ByteArrayOutputStream(); InputStream inputStream = requestContext.getEntityStream())
        {
            ReaderWriter.writeTo(inputStream, outStream);
            byte[] requestEntity = outStream.toByteArray();

            String bodyStr = new String(requestEntity);

            requestContext.setEntityStream(new ByteArrayInputStream(requestEntity));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    private class MHBSecurityContext implements SecurityContext
    {
        private String username;
        private boolean secure;
        private String authenticationScheme;

        public MHBSecurityContext(ContainerRequestContext requestContext, String username)
        {
            this.username = username;
            secure = requestContext.getSecurityContext().isSecure();
            authenticationScheme = requestContext.getSecurityContext().getAuthenticationScheme();
        }

        @Override
        public Principal getUserPrincipal() {
            return new Principal() {
                @Override
                public String getName() {
                    return username;
                }
            };
        }

        @Override
        public boolean isUserInRole(String role) {

            try
            {
                PermissionKeyEnum permission = PermissionKeyEnum.valueOf(role);

                if (AccessControlUtil.hasReadAccess(username, permission))
                {
                    return true;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        public boolean isSecure() {
            return secure;
        }

        @Override
        public String getAuthenticationScheme() {
            return authenticationScheme;
        }
    }

}
