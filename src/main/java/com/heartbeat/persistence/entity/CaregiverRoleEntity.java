package com.heartbeat.persistence.entity;

import javax.persistence.*;

/**
 * Created by valerie on 1/29/17.
 */
@Entity
@Table(name = "hb_patient_caregiver_role_internal")
@IdClass(CaregiverRoleEntityPK.class)
public class CaregiverRoleEntity {

    @Id
    private int roleId;

    @Id
    @ManyToOne
    @JoinColumn(name = "careRelationId")
    private CaregiverEntity caregiverEntity;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public CaregiverEntity getCaregiverEntity() {
        return caregiverEntity;
    }

    public void setCaregiverEntity(CaregiverEntity caregiverEntity) {
        this.caregiverEntity = caregiverEntity;
    }
}
