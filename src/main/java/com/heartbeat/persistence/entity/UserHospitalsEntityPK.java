package com.heartbeat.persistence.entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by valerie on 1/26/17.
 */
public class UserHospitalsEntityPK implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private HierarchyEntity hierarchyEntity;


    @Id
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    public HierarchyEntity getHierarchyEntity() {
        return hierarchyEntity;
    }

    public void setHierarchyEntity(HierarchyEntity hierarchyEntity) {
        this.hierarchyEntity = hierarchyEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHospitalsEntityPK that = (UserHospitalsEntityPK) o;

        if (hierarchyEntity.getHospitalId() != that.hierarchyEntity.getHospitalId()) return false;
        if (userEntity.getUserId() != that.userEntity.getUserId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hierarchyEntity.getHospitalId();
        result = 31 * result + userEntity.getUserId();
        return result;
    }
}
