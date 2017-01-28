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
    @Path("/internalCaregiver/namednative/{hospitalId}/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUserAndHospitalNamedQuery(@PathParam("hospitalId") int hospitalId, @PathParam("userId") int userId, @Context InjectedRequestData injectedRequestData) {

        List<PatientCaregiverInternalEntity> caregiverList = patientCaregiverInternalService.findByUserAndHospitalNamedQuery(hospitalId,userId);

        GenericEntity<List<PatientCaregiverInternalEntity>> list = new GenericEntity<List<PatientCaregiverInternalEntity>>(caregiverList) {};
        return Response.ok(list).build();
    }

    @GET
    @Path("/internalCaregiver/dynamicnative/hospital/{hospitalId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByHospitalDynamicQuery(@PathParam("hospitalId") int hospitalId, @Context InjectedRequestData injectedRequestData) {

        List<PatientCaregiverInternalEntity> caregiverList = patientCaregiverInternalService.findByHospitalDynamicQuery(hospitalId);

        GenericEntity<List<PatientCaregiverInternalEntity>> list = new GenericEntity<List<PatientCaregiverInternalEntity>>(caregiverList) {};
        return Response.ok(list).build();
    }

    @GET
    @Path("/internalCaregiver/dynamicnative/user/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCaregiverIdByUserDynamicQuery(@PathParam("userId") int userId, @Context InjectedRequestData injectedRequestData) {

        Integer id = patientCaregiverInternalService.findCaregiverIdByUserDynamicQuery(userId);
        return Response.ok().entity(id).build();
    }
}
