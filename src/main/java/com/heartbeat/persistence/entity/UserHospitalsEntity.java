package com.heartbeat.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by valerie on 1/26/17.
 */
@Entity
@Table(name = "hb_user_hospitals")
@IdClass(UserHospitalsEntityPK.class)
@NamedQueries({
        @NamedQuery(name="UserHospitalsEntity.findAssociatedHospitals", query="SELECT uh FROM UserHospitalsEntity uh WHERE uh.userEntity.userId = :userId")
})
public class UserHospitalsEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private HierarchyEntity hierarchyEntity;

    @Id
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    private boolean isPrimary;
    private Timestamp lastUpdateDateTime;

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

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public Timestamp getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Timestamp lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

}
