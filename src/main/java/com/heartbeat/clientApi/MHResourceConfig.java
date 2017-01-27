package com.heartbeat.clientApi;

import com.heartbeat.clientApi.demoResource.AuthResource;
import com.heartbeat.clientApi.demoResource.Demo1Resource;
import com.heartbeat.clientApi.demoResource.Demo2Resource;
import com.heartbeat.clientApi.vo.InjectedRequestData;
import com.heartbeat.clientApi.vo.InjectedRequestDataFactory;
import com.heartbeat.resource.*;
import org.glassfish.hk2.api.PerLookup;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;


/**
 * Created by michaelkellstrand on 12/7/16.
 */
public class MHResourceConfig extends ResourceConfig
{
    public MHResourceConfig() {

        // Configure injection of extra request data
        register(new AbstractBinder(){
            @Override
            protected void configure() {
                bindFactory(InjectedRequestDataFactory.class)
                        .to(InjectedRequestData.class)
                        .in(PerLookup.class);
            }
        });

        register(JacksonFeature.class);

        // Register our Authentication Filter
        register(AuthenticationFilter.class);

        // Register Roles-Allowed feature
        register(RolesAllowedDynamicFeature.class);

        // Register the auth resource
        register(AuthResource.class);


        // TODO: remove
        register(Demo1Resource.class);
        register(Demo2Resource.class);

        register(AssignmentResource.class);
        register(HierarchyResource.class);
        register(PatientResource.class);
        register(PatientCaregiverInternalResource.class);
        register(UserResource.class);

    }
}

