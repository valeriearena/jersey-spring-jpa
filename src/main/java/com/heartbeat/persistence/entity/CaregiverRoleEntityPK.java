package com.heartbeat.persistence.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by valerie on 1/29/17.
 */
public class CaregiverRoleEntityPK implements Serializable {

    @Id
    private int roleId;

    @Id
    @ManyToOne
    @JoinColumn(name = "careRelationId")
    private CaregiverEntity caregiverEntity;

    public CaregiverEntity getCaregiverEntity() {
        return caregiverEntity;
    }

    public void setCaregiverEntity(CaregiverEntity caregiverEntity) {
        this.caregiverEntity = caregiverEntity;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
