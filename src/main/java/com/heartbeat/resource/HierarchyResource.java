package com.heartbeat.resource;

import com.heartbeat.clientApi.baseResource.ClinicalResource;
import com.heartbeat.clientApi.vo.InjectedRequestData;
import com.heartbeat.persistence.entity.HierarchyEntity;
import com.heartbeat.service.HierarchyService;
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
 * Created by valerie on 1/23/17.
 */
@Service
@Scope("prototype")
public class HierarchyResource extends ClinicalResource {

    @Autowired
    private HierarchyService hierarchyService;

    @GET
    @Path("/hierarchy/ping/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping(@PathParam("name") String name) {
        return "pong " + name;
    }

    @GET
    @Path("/hierarchy/{levelId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHierarchy(@PathParam("levelId") int levelId, @Context InjectedRequestData injectedRequestData) {

        HierarchyEntity hierarchyEntity = hierarchyService.getHierarchy(levelId);

        return Response.ok().entity(hierarchyEntity).build();
    }

    @GET
    @Path("/hierarchy/all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context InjectedRequestData injectedRequestData) {

        List<HierarchyEntity> hierarchyEntityList = hierarchyService.getAll();

        GenericEntity<List<HierarchyEntity>> list = new GenericEntity<List<HierarchyEntity>>(hierarchyEntityList) {};
        return Response.ok(list).build();

    }

    @GET
    @Path("/hierarchy/root")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRootHierarchy(@Context InjectedRequestData injectedRequestData) {

        List<HierarchyEntity> hierarchyEntityList = hierarchyService.getRootHierarchy();

        GenericEntity<List<HierarchyEntity>> list = new GenericEntity<List<HierarchyEntity>>(hierarchyEntityList) {};
        return Response.ok(list).build();
    }

    @GET
    @Path("/hierarchy/children/{parentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHierarchyImmediateChildren(@PathParam("parentId") int parentId, @Context InjectedRequestData injectedRequestData) {

        List<HierarchyEntity> hierarchyEntityList = hierarchyService.getHierarchyImmediateChildren(parentId);

        GenericEntity<List<HierarchyEntity>> list = new GenericEntity<List<HierarchyEntity>>(hierarchyEntityList) {};
        return Response.ok(list).build();
    }
}
