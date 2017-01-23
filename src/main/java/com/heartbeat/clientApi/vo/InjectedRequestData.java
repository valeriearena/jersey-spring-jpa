package com.heartbeat.clientApi.vo;

/**
 * Data items obtained by our Jersey AuthenticationFilter while validating the user request that would be useful to downstream services.
 * The Filter will add this object to each service request before sending it along.
 * Service methods may inject it in their signature using:  @Context InjectedRequestData injectedRequestData
 *
 * Created by michaelkellstrand on 11/22/16.
 */
public class InjectedRequestData
{
    private boolean authenticated;
    private String username;
    private boolean initialized;

    public InjectedRequestData() {}

    public InjectedRequestData(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public InjectedRequestData(boolean authenticated, String username, boolean initialized) {
        this.authenticated = authenticated;
        this.username = username;
        this.initialized = initialized;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }
}
