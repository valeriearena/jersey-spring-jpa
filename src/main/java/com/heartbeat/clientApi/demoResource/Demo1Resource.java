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
 *
 * Created by michaelkellstrand on 11/21/16.
 */
@Service
public class Demo1Resource extends ClinicalResource {

    @GET
    @Path("/ping1/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping(@PathParam("name") String name) {
        return "pong " + name;
    }


    @Path("/demo1")
    @POST
    @Consumes(MHMediaType.ICAPI_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed(PermissionKeyEnum.Constants.patientPhotography)
    public Response demoPost(DemoRequestData requestData, @Context InjectedRequestData injectedRequestData){

        String username = injectedRequestData.getUsername();

        DemoResponseData responseData1 = new DemoResponseData(username, requestData.getVar1(), requestData.getVar2());
        responseData1.setSuccess(true);
        responseData1.setStatus(ServiceResponseStatus.SUCCESS);

        return buildResponse(Response.Status.OK, responseData1);
    }

    /*

    curl -v -d '{"var1":"value1","var2":"value2"}' -H "Content-Type:application/vnd.mobileheartbeat.icapi+json" -H "Authorization: Bearer 9e113d2f-9fd6-4c10-b58f-3d76da83704d" -H "Checksum: 1234567" -X POST http://localhost:8080/heartbeat/icapi/clinical/demoService


     */
}
