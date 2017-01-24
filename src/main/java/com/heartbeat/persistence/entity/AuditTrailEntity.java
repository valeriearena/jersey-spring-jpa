package com.heartbeat.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by valerie on 1/24/17.
 */
@Entity
@Table(name = "hb_audit_trail", schema = "dbo", catalog = "heartbeat")
public class AuditTrailEntity {

    private int trailId;
    private String userName;
    private String roleName;
    private int patientId;
    private int wardId;
    private Timestamp updateTime;
    private String actionName;
    private String actionValue1;
    private String actionValue2;
    private String actionValue3;
    private String actionValue4;
    private String actionValue5;
    private String actionValue6;

    @Id
    @Column(name = "trailId")
    public int getTrailId() {
        return trailId;
    }

    public void setTrailId(int trailId) {
        this.trailId = trailId;
    }

    @Basic(fetch = FetchType.EAGER)
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "roleName")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "patientId")
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "wardId")
    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "actionName")
    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Basic
    @Column(name = "actionValue1")
    public String getActionValue1() {
        return actionValue1;
    }

    public void setActionValue1(String actionValue1) {
        this.actionValue1 = actionValue1;
    }

    @Basic
    @Column(name = "actionValue2")
    public String getActionValue2() {
        return actionValue2;
    }

    public void setActionValue2(String actionValue2) {
        this.actionValue2 = actionValue2;
    }

    @Basic
    @Column(name = "actionValue3")
    public String getActionValue3() {
        return actionValue3;
    }

    public void setActionValue3(String actionValue3) {
        this.actionValue3 = actionValue3;
    }

    @Basic
    @Column(name = "actionValue4")
    public String getActionValue4() {
        return actionValue4;
    }

    public void setActionValue4(String actionValue4) {
        this.actionValue4 = actionValue4;
    }

    @Basic
    @Column(name = "actionValue5")
    public String getActionValue5() {
        return actionValue5;
    }

    public void setActionValue5(String actionValue5) {
        this.actionValue5 = actionValue5;
    }

    @Basic
    @Column(name = "actionValue6")
    public String getActionValue6() {
        return actionValue6;
    }

    public void setActionValue6(String actionValue6) {
        this.actionValue6 = actionValue6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuditTrailEntity that = (AuditTrailEntity) o;

        if (trailId != that.trailId) return false;
        if (patientId != that.patientId) return false;
        if (wardId != that.wardId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (actionName != null ? !actionName.equals(that.actionName) : that.actionName != null) return false;
        if (actionValue1 != null ? !actionValue1.equals(that.actionValue1) : that.actionValue1 != null) return false;
        if (actionValue2 != null ? !actionValue2.equals(that.actionValue2) : that.actionValue2 != null) return false;
        if (actionValue3 != null ? !actionValue3.equals(that.actionValue3) : that.actionValue3 != null) return false;
        if (actionValue4 != null ? !actionValue4.equals(that.actionValue4) : that.actionValue4 != null) return false;
        if (actionValue5 != null ? !actionValue5.equals(that.actionValue5) : that.actionValue5 != null) return false;
        if (actionValue6 != null ? !actionValue6.equals(that.actionValue6) : that.actionValue6 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trailId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + patientId;
        result = 31 * result + wardId;
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (actionName != null ? actionName.hashCode() : 0);
        result = 31 * result + (actionValue1 != null ? actionValue1.hashCode() : 0);
        result = 31 * result + (actionValue2 != null ? actionValue2.hashCode() : 0);
        result = 31 * result + (actionValue3 != null ? actionValue3.hashCode() : 0);
        result = 31 * result + (actionValue4 != null ? actionValue4.hashCode() : 0);
        result = 31 * result + (actionValue5 != null ? actionValue5.hashCode() : 0);
        result = 31 * result + (actionValue6 != null ? actionValue6.hashCode() : 0);
        return result;
    }
}
