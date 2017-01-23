package com.heartbeat.clientApi;

/**
 * Custom MIME-TYPE's accepted by the Client API
 *
 * Created by michaelkellstrand on 12/16/16.
 */
public class MHMediaType
{
    // Internal helper constants
    private static final String ICAPI_PREFIX = "application/vnd.mobileheartbeat.icapi";
    private static final String JSON = "+json";
    private static final String XML  = "+xml";

    // Standard version-less 'icapi' mime-types.
    // These should be used whenever possible
    public static final String ICAPI_JSON = ICAPI_PREFIX + JSON;
    public static final String ICAPI_XML = ICAPI_PREFIX + XML;

    // Example of a versioned 'icapi' mime-type.
    // Used during a transition period when a service is enhanced.
    public static final String ICAPI_JSON_VERSION_11_1 = ICAPI_PREFIX + "-v11.1" + JSON;
}
