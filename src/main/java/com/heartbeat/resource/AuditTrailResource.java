package com.heartbeat.resource;

import com.heartbeat.clientApi.baseResource.ClinicalResource;
import com.heartbeat.service.AuditTrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by valerie on 1/28/17.
 */
@Service
@Scope("prototype")
public class AuditTrailResource extends ClinicalResource {

    @Autowired
    private AuditTrailService auditTrailService;

    @GET
    @Path("/audit/ping/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping(@PathParam("name") String name) {
        return "pong " + name;
    }

    @POST
    @Path("/audit/remove/{trailId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("trailId") int trailId){

        try {
            auditTrailService.remove(trailId);
            return Response.ok().build();
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
