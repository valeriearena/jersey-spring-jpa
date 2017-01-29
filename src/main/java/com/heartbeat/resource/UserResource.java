package com.heartbeat.resource;

import com.heartbeat.clientApi.baseResource.ClinicalResource;
import com.heartbeat.clientApi.vo.InjectedRequestData;
import com.heartbeat.persistence.entity.UserEntity;
import com.heartbeat.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserResource extends ClinicalResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class.getName());

    @Autowired
    private UserService userService;

    @GET
    @Path("/user/ping/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping(@PathParam("name") String name) {
        return "pong " + name;
    }

    @GET
    @Path("/user/byId/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatients(@PathParam("userId") int userId, @Context InjectedRequestData injectedRequestData) {

        UserEntity userEntity = userService.find(userId);

        return Response.ok().entity(userEntity).build();
    }

    @GET
    @Path("/user/byName/{userName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByName(@PathParam("userName") String userName, @Context InjectedRequestData injectedRequestData) {

        UserEntity userEntity = userService.findByUserName(userName);

        return Response.ok().entity(userEntity).build();
    }

    @GET
    @Path("/user/assignmentCount/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAssignmentCount(@PathParam("userId") int userId, @Context InjectedRequestData injectedRequestData) {

        UserEntity userEntity = userService.findAssignments(userId);

        return Response.ok().entity(userEntity).build();
    }

    @GET
    @Path("/user/userNameCount/{likeUserName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserCount(@PathParam("likeUserName") String likeUserName, @Context InjectedRequestData injectedRequestData) {

        Integer count = userService.findCount(likeUserName);

        return Response.ok().entity(count).build();
    }

    @POST
    @Path("/user/onbreak/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserOnBreak(@PathParam("userId") int userId, @Context InjectedRequestData injectedRequestData) {

        userService.updateUserOnBreak(userId);

        return Response.ok().build();
    }

    @POST
    @Path("/user/offbreak/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserOffBreak(@PathParam("userId") int userId, @Context InjectedRequestData injectedRequestData) {

        userService.updateUserOffBreak(userId);

        return Response.ok().build();
    }



}
