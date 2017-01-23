package com.heartbeat.clientApi;

import javax.ws.rs.core.Response;

/**
 * An Exception wrapping a service Response object
 *
 * Created by michaelkellstrand on 12/21/16.
 */
public class AuthorizationExceptionWithResponse extends Exception
{
    private Response response;

    public AuthorizationExceptionWithResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
