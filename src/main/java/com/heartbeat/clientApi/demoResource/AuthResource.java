package com.heartbeat.clientApi.demoResource;

import com.heartbeat.clientApi.baseResource.NonClinicalResource;
import com.heartbeat.clientApi.util.EncryptionException;
import com.heartbeat.clientApi.util.EncryptionUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;
import java.util.UUID;

/**
 * Authorization service. Called to authorize a client for further access to MH-CURE systems.
 * Authentication will be performed, and an access token obtained, via an OAuth 2.0 ‘Client Credentials Grant’ transaction.
 * <p>
 * Created by michaelkellstrand on 12/15/16.
 */
@Component
public class AuthResource extends NonClinicalResource {

    // We support the following grant types
    private static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";   // Used for normal auth and autonomous badge registration
    private static final String GRANT_TYPE_ACCESS_CARD = "access_card";                 // Used for quick-launch

    // We support the following parameters
    private static final String FORM_PARAM_GRANT_TYPE = "grant_type";           // Required - requested grant type
    private static final String FORM_PARAM_RACK_LOCATION = "rack_location";     // Optional - passed with 'access_card' grant type to support QuickLaunch
    private static final String FORM_PARAM_ACCESS_CARD_ID = "access_card_id";   // Optional - passed with 'client_credentials' grant type for autonomous badge registration

    private static final String ERROR_UNSUPPORTED_GRANT_TYPE = "unsupported_grant_type";

    @GET
    @Path("/ping/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping(@PathParam("name") String name) {
        return "pong " + name;
    }

    @Path("/auth")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authPost(@FormParam(FORM_PARAM_GRANT_TYPE) String grantType,
                             @FormParam(FORM_PARAM_RACK_LOCATION) String rackLocation,
                             @FormParam(FORM_PARAM_ACCESS_CARD_ID) String accessCardId) {

        // Verify the requested grant type is valid.  We only support: grant_type=client_credentials
        if (!GRANT_TYPE_CLIENT_CREDENTIALS.equals(grantType)) {
            return Response.serverError().build();
        }
        String authHeader = null;
        // Get the authentication header
        if (authHeader == null) {
            return Response.serverError().build();
        }

        // Parse and decode the credentials from the authentication header
        String[] credentials = decodeBase64(authHeader);
        if (credentials == null) {
            return Response.serverError().build();
        }

        String username = credentials[0];
        String password = credentials[1];

        // Validate the credentials
        try {
            // The user password is sent encrypted, decrypt it first
            password = EncryptionUtil.decryptAES256(password, "s!yAqepesPUtrerePU@Wutr!nAgU5_#h");

        }
        catch (EncryptionException e) {
            return Response.serverError().build();
        }

        OAuthResponse entity = new OAuthResponse(UUID.randomUUID().toString(), "Bearer", 72 * 60 * 60);

        return buildResponse(Response.Status.OK, entity);
    }

    /**
     * Decode the basic auth and convert it to array login/password
     *
     * @param auth The string encoded authentication
     * @return The array containing login (index 0), the password (index 1)
     */
    private String[] decodeBase64(String auth) {
        // Remove the authentication prefix: "Basic THE_BASE_64" -> "THE_BASE_64"
        auth = auth.replaceFirst("[B|b]asic ", "");

        // Decode the Base64 into byte[]
        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(auth);

        // If the decode fails in any case
        if (decodedBytes == null || decodedBytes.length == 0) {
            return null;
        }

        // Now we can split the byte[] into an array :
        //  - the first segment is login,
        //  - the second segment is password
        String[] credentials = new String(decodedBytes).split(":", 2);

        // Make sure both a username and password are present
        if (credentials == null || credentials.length != 2 || StringUtils.isEmpty(credentials[0]) || StringUtils.isEmpty(credentials[1])) {
            return null;
        }

        return credentials;
    }

    //@ApiModel
    private class OAuthResponse {
        //@ApiModelProperty(required = true, value = "Access token.")
        private String access_token;

        //@ApiModelProperty(required = true, value = "Token type.")
        private String token_type;

        //@ApiModelProperty(required = true, value = "Expires in.")
        private long expires_in;

        public OAuthResponse(String access_token, String token_type, long expires_in) {
            this.access_token = access_token;
            this.token_type = token_type;
            this.expires_in = expires_in;
        }

        @SuppressWarnings("unused")
        public String getAccess_token() {
            return access_token;
        }

        @SuppressWarnings("unused")
        public String getToken_type() {
            return token_type;
        }

        @SuppressWarnings("unused")
        public long getExpires_in() {
            return expires_in;
        }
    }


}
