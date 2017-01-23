package com.heartbeat.clientApi.demoResource;

import com.heartbeat.clientApi.MHMediaType;
import com.heartbeat.clientApi.baseResource.ClinicalResource;
import com.heartbeat.clientApi.enums.PermissionKeyEnum;
import com.heartbeat.clientApi.enums.ServiceResponseStatus;
import com.heartbeat.clientApi.vo.InjectedRequestData;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by valerie on 1/6/17.
 */
@Service
public class Demo2Resource extends ClinicalResource {

    @GET
    @Path("/ping2/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping(@PathParam("name") String name) {
        return "pong " + name;
    }

    @POST
    @Path("/demo2")
    @Consumes(MHMediaType.ICAPI_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(PermissionKeyEnum.Constants.patientPhotography)
    public Response demoPost(DemoRequestData requestData, @Context InjectedRequestData injectedRequestData){

        String username = injectedRequestData.getUsername();

        DemoResponseData responseData2 = new DemoResponseData(username, requestData.getVar1(), requestData.getVar2());
        responseData2.setSuccess(true);
        responseData2.setStatus(ServiceResponseStatus.SUCCESS);

        return buildResponse(Response.Status.OK, responseData2);
    }

}

