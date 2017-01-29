package com.heartbeat.resource;

import com.heartbeat.clientApi.baseResource.ClinicalResource;
import com.heartbeat.clientApi.vo.InjectedRequestData;
import com.heartbeat.persistence.entity.PatientCaregiverInternalEntity;
import com.heartbeat.service.PatientCaregiverInternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
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
    @Path("/internalCaregiver/namednative/byUserAndPatient/{userId}/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findNamedNativeByUserAndPatient(@PathParam("userId") int userId, @PathParam("patientId") int patientId, @Context InjectedRequestData injectedRequestData) {

        PatientCaregiverInternalEntity caregiver = patientCaregiverInternalService.findNamedNativeByUserAndPatient(userId, patientId);

        return Response.ok().entity(caregiver).build();
    }

    @GET
    @Path("/internalCaregiver/namednative/byUserAndHospital/{userId}/{hospitalId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findNamedNativeByUserAndHospital(@PathParam("userId") int userId, @PathParam("hospitalId") int hospitalId, @Context InjectedRequestData injectedRequestData) {

        List<PatientCaregiverInternalEntity> caregiverList = patientCaregiverInternalService.findNamedNativeByUserAndHospital(userId, hospitalId);

        GenericEntity<List<PatientCaregiverInternalEntity>> list = new GenericEntity<List<PatientCaregiverInternalEntity>>(caregiverList) {};
        return Response.ok(list).build();
    }

    @GET
    @Path("/internalCaregiver/dynamicnative/byUserAndHospital/{userId}/{hospitalId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDynamicNativeByUserAndHospital(@PathParam("userId") int userId, @PathParam("hospitalId") int hospitalId, @Context InjectedRequestData injectedRequestData) {

        List<PatientCaregiverInternalEntity> caregiverList = patientCaregiverInternalService.findDynamicNativeByUserAndHospital(userId, hospitalId);

        GenericEntity<List<PatientCaregiverInternalEntity>> list = new GenericEntity<List<PatientCaregiverInternalEntity>>(caregiverList) {};
        return Response.ok(list).build();
    }

    @GET
    @Path("/internalCaregiver/dynamicnative/byUserAndPatient/{userId}/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDynamicNativeByUserAndPatient(@PathParam("userId") int userId, @PathParam("patientId") int patientId, @Context InjectedRequestData injectedRequestData) {

        Integer id = patientCaregiverInternalService.findDynamicNativeByUserAndPatient(userId, patientId);
        return Response.ok().entity(id).build();
    }
}
