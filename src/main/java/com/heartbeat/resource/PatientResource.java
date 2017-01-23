package com.heartbeat.resource;

import com.heartbeat.clientApi.baseResource.ClinicalResource;
import com.heartbeat.persistence.entity.PatientEntity;
import com.heartbeat.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by valerie on 1/22/17.
 */
@Service
public class PatientResource extends ClinicalResource {

    @Autowired
    private PatientService patientService;

    @GET
    @Path("/patient/ping/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping(@PathParam("name") String name) {
        return "pong " + name;
    }

    @GET
    @Path("/patient/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatient(@PathParam("patientId") int patientId) {

        PatientEntity patientEntity = patientService.getPatient(patientId);

        return Response.ok().entity(patientEntity).build();
    }

}
