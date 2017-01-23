package com.heartbeat.clientApi.vo;

import com.heartbeat.clientApi.enums.ServiceResponseStatus;

/**
 * All client API responses will include this base set of fields at a minimum.
 *
 * Created by michaelkellstrand on 12/1/16.
 */
public class BaseServiceResponse
{
    private boolean success;    // true if the request was processed successfully.
                                // false if there was an error, in which case the following fields will contain additional information.
    private ServiceResponseStatus status;   // an enum of supported response status values
    private String errMsg;      // optional additional error detail, for debug/logging purposes
    private String userMsg;     // optional pretty error message to be displayed to the user

    public BaseServiceResponse() {
    }

    public BaseServiceResponse(boolean success, ServiceResponseStatus status) {
        this.success = success;
        this.status = status;
    }

    public BaseServiceResponse(boolean success, ServiceResponseStatus status, String errMsg, String userMsg) {
        this.success = success;
        this.status = status;
        this.errMsg = errMsg;
        this.userMsg = userMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ServiceResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceResponseStatus status) {
        this.status = status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getUserMsg() {
        return userMsg;
    }

    public void setUserMsg(String userMsg) {
        this.userMsg = userMsg;
    }
}
