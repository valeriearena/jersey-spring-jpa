package com.heartbeat.clientApi.util;

import com.heartbeat.clientApi.enums.PermissionKeyEnum;

/**
 * Utility class for convenient way to perform access control checks
 * User: saji
 * Date: 7/17/13 8:31 AM
 */
public class AccessControlUtil {


    public static boolean hasReadAccess(String userName, PermissionKeyEnum permissionKey){
        return true;
    }


}
