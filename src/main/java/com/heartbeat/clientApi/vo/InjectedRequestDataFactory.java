package com.heartbeat.clientApi.vo;

import org.glassfish.hk2.api.Factory;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;

/**
 * Created by michaelkellstrand on 12/7/16.
 */
public class InjectedRequestDataFactory implements Factory<InjectedRequestData>
{
    public static final String INJECTED_REQUEST_DATA_PROPERTY = "injectedRequestData";

    private final ContainerRequestContext context;

    @Inject
    public InjectedRequestDataFactory(ContainerRequestContext context) {
        this.context = context;
    }

    @Override
    public InjectedRequestData provide() {
        return (InjectedRequestData)context.getProperty(INJECTED_REQUEST_DATA_PROPERTY);
    }

    @Override
    public void dispose(InjectedRequestData t) {}
}
