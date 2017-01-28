package com.heartbeat.resource;

import com.heartbeat.clientApi.baseResource.ClinicalResource;
import com.heartbeat.clientApi.vo.InjectedRequestData;
import com.heartbeat.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by valerie on 1/26/17.
 */
@Service
@Scope("prototype")
public class AssignmentResource extends ClinicalResource {

    @Autowired
    private AssignmentService assignmentService;

    @GET
    @Path("/assignment/ping/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping(@PathParam("name") String name) {
        return "pong " + name;
    }

    @POST
    @Path("/assignment/cmt/{userId}/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignPatientCmt(@PathParam("userId") int userId, @PathParam("patientId") int patientId, @Context InjectedRequestData injectedRequestData) {

        try {
            boolean isSuccessful = assignmentService.assignPatientCmt(userId, patientId);

            if(!isSuccessful)return Response.status(Response.Status.CONFLICT).build();

            return Response.ok().build();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Path("/assignment/bmt/{userId}/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignPatientBmt(@PathParam("userId") int userId, @PathParam("patientId") int patientId, @Context InjectedRequestData injectedRequestData) {

        try {
            boolean isSuccessful = assignmentService.assignPatientBmt(userId, patientId);

            if (!isSuccessful) return Response.status(Response.Status.CONFLICT).build();

            return Response.ok().build();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).build();
        }

    }

    @PUT
    @Path("/assignment/unassign/{userId}/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response unassignPatient(@PathParam("userId") int userId, @PathParam("patientId") int patientId, @Context InjectedRequestData injectedRequestData) {

        assignmentService.unassignPatient(userId, patientId);
        return Response.ok().build();
    }

}
