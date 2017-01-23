package com.heartbeat.clientApi.baseResource;

import javax.ws.rs.Path;

/**
 * Base abstract resource for all 'non-clinical' resources.
 *
 * Created by michaelkellstrand on 12/29/16.
 */
@Path("/nonclinical")
public abstract class NonClinicalResource extends BaseResource {}
