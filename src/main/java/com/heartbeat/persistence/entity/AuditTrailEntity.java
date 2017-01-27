package com.heartbeat.persistence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by valerie on 1/24/17.
 */
@Entity
@Table(name = "hb_audit_trail")
public class AuditTrailEntity {

    public enum AuditTrailEnum{
        UPDATE_PATIENT;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "trailId")
    private int trailId;

    @Column(name = "userName")
    private String userName;

    @Enumerated(EnumType.STRING)
    private AuditTrailEnum actionName;

    private String roleName;
    private int patientId;
    private int wardId;
    private Date updateTime = new Date();
    private String actionValue1;
    private String actionValue2;
    private String actionValue3;
    private String actionValue4;
    private String actionValue5;
    private String actionValue6;

    public int getTrailId() {
        return trailId;
    }

    public void setTrailId(int trailId) {
        this.trailId = trailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public AuditTrailEnum getActionName() {
        return actionName;
    }

    public void setActionName(AuditTrailEnum actionName) {
        this.actionName = actionName;
    }

    public String getActionValue1() {
        return actionValue1;
    }

    public void setActionValue1(String actionValue1) {
        this.actionValue1 = actionValue1;
    }

    public String getActionValue2() {
        return actionValue2;
    }

    public void setActionValue2(String actionValue2) {
        this.actionValue2 = actionValue2;
    }

    public String getActionValue3() {
        return actionValue3;
    }

    public void setActionValue3(String actionValue3) {
        this.actionValue3 = actionValue3;
    }

    public String getActionValue4() {
        return actionValue4;
    }

    public void setActionValue4(String actionValue4) {
        this.actionValue4 = actionValue4;
    }

    public String getActionValue5() {
        return actionValue5;
    }

    public void setActionValue5(String actionValue5) {
        this.actionValue5 = actionValue5;
    }

    public String getActionValue6() {
        return actionValue6;
    }

    public void setActionValue6(String actionValue6) {
        this.actionValue6 = actionValue6;
    }
}
