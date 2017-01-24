package com.heartbeat.resource;

import com.heartbeat.clientApi.baseResource.ClinicalResource;
import com.heartbeat.persistence.entity.PatientCaregiverInternalEntity;
import com.heartbeat.service.PatientCaregiverInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by valerie on 1/24/17.
 */
@Service
@Scope("prototype")
public class PatientCaregiverInternalResource extends ClinicalResource {

    @Autowired
    private PatientCaregiverInternalService patientCaregiverInternalService;

    @GET
    @Path("/internalCaregiver/ping/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping(@PathParam("name") String name) {
        return "pong " + name;
    }

    @GET
    @Path("/internalCaregiver/{hospitalId}/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUserAndHospital(@PathParam("hospitalId") int hospitalId, @PathParam("userId") int userId) {

        List<PatientCaregiverInternalEntity> caregiverList = patientCaregiverInternalService.findByUserAndHospital(hospitalId,userId);

        GenericEntity<List<PatientCaregiverInternalEntity>> list = new GenericEntity<List<PatientCaregiverInternalEntity>>(caregiverList) {};
        return Response.ok(list).build();
    }

    @GET
    @Path("/internalCaregiver/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCaregiverIdByUser(@PathParam("userId") int userId) {

        Integer id = patientCaregiverInternalService.findCaregiverIdByUser(userId);
        return Response.ok().entity(id).build();
    }
}
