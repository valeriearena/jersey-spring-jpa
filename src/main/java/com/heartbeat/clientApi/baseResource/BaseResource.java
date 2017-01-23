package com.heartbeat.clientApi.baseResource;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * Base class to build all Client API resource classes on.
 * Supplies common utility methods.
 * <p>
 * Created by michaelkellstrand on 12/19/16.
 */
public abstract class BaseResource {
    /**
     * Builds a common web service response object.
     *
     * @param status The HTTP response status
     * @param entity The data object to marshall and write to the response body
     * @return Response object for the web service method to return
     */
    protected Response buildResponse(Response.Status status, Object entity) {
        return Response.status(status)
                .header(HttpHeaders.CACHE_CONTROL, "no-store")
                .header("Pragma", "no-cache")
                .entity(entity).build();
    }
}
