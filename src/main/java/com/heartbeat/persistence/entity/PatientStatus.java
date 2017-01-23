package com.heartbeat.persistence.entity;

/**
 * Created by valerie on 1/21/17.
 */
public class PatientStatus {

    private Integer patientId;
    private Integer labResultsCount;
    private Integer vitalSignAlertCount;
    private Integer nurseCallActive;
    private Integer ordersAlertCount;
    private Integer photoSessionCount;
    private Integer activeTelemetryAlarms;
    private Integer telemetryAlertsAreSuppressed;
    private Integer unassignmentAlertSent;
    private Integer sensitivePhotoSessionCount;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getLabResultsCount() {
        return labResultsCount;
    }

    public void setLabResultsCount(Integer labResultsCount) {
        this.labResultsCount = labResultsCount;
    }

    public Integer getVitalSignAlertCount() {
        return vitalSignAlertCount;
    }

    public void setVitalSignAlertCount(Integer vitalSignAlertCount) {
        this.vitalSignAlertCount = vitalSignAlertCount;
    }

    public Integer getNurseCallActive() {
        return nurseCallActive;
    }

    public void setNurseCallActive(Integer nurseCallActive) {
        this.nurseCallActive = nurseCallActive;
    }

    public Integer getOrdersAlertCount() {
        return ordersAlertCount;
    }

    public void setOrdersAlertCount(Integer ordersAlertCount) {
        this.ordersAlertCount = ordersAlertCount;
    }

    public Integer getPhotoSessionCount() {
        return photoSessionCount;
    }

    public void setPhotoSessionCount(Integer photoSessionCount) {
        this.photoSessionCount = photoSessionCount;
    }

    public Integer getActiveTelemetryAlarms() {
        return activeTelemetryAlarms;
    }

    public void setActiveTelemetryAlarms(Integer activeTelemetryAlarms) {
        this.activeTelemetryAlarms = activeTelemetryAlarms;
    }

    public Integer getTelemetryAlertsAreSuppressed() {
        return telemetryAlertsAreSuppressed;
    }

    public void setTelemetryAlertsAreSuppressed(Integer telemetryAlertsAreSuppressed) {
        this.telemetryAlertsAreSuppressed = telemetryAlertsAreSuppressed;
    }

    public Integer getUnassignmentAlertSent() {
        return unassignmentAlertSent;
    }

    public void setUnassignmentAlertSent(Integer unassignmentAlertSent) {
        this.unassignmentAlertSent = unassignmentAlertSent;
    }

    public Integer getSensitivePhotoSessionCount() {
        return sensitivePhotoSessionCount;
    }

    public void setSensitivePhotoSessionCount(Integer sensitivePhotoSessionCount) {
        this.sensitivePhotoSessionCount = sensitivePhotoSessionCount;
    }
}
