/*
 * Copyright (c) 2014 Mobile Heartbeat, Inc - All Rights Reserved.
 * Proprietary and confidential.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */

package com.heartbeat.clientApi.enums;

/**
 * List of all permission names(keys) available in Heartbeat. Used for easy access and avoid duplication of hardcoded
 * strings. Matches the keys in permissions.xml meta data file
 * User: saji
 * Date: 7/16/13 5:15 PM
 */
public enum PermissionKeyEnum {
    clinicalAccess,
    setMyPatient,
    doStaffAssignments,
    confirmLabOrders,
    patientPhotography,
    sensitivePhotoAccess,
    receiveNurseCalls,
    restrictLocationAccess,
    clientAdmin,

    //Web Admin
    webAdmin,
    manageSecurity,
    bizReports;

    // These constant versions of the above enum values are needed for use
    // in jax-ws web service @RolesAllowed() annotations.
    // Annotations take String constant values and thus enums cannot be used.
    public static class Constants {
        public static final String clinicalAccess = "clinicalAccess";
        public static final String setMyPatient = "setMyPatient";
        public static final String doStaffAssignments = "doStaffAssignments";
        public static final String confirmLabOrders = "confirmLabOrders";
        public static final String patientPhotography = "patientPhotography";
        public static final String sensitivePhotoAccess = "sensitivePhotoAccess";
        public static final String receiveNurseCalls = "receiveNurseCalls";
        public static final String restrictLocationAccess = "restrictLocationAccess";
        public static final String clientAdmin = "clientAdmin";
    }
}
