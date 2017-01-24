package com.heartbeat.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by valerie on 1/24/17.
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id") //400 Bad Request: Jackson won't serialize self-ref
@Entity
@Table(name = "hb_patient_caregiver_internal", schema = "dbo", catalog = "heartbeat")
@NamedNativeQueries({
        @NamedNativeQuery(name="PatientCaregiverInternalEntity.findByUserAndHospital",
                query="SELECT ci.id, ci.userId, ci.patientId, ci.thirdPartySource, ci.lastUpdated " +
                        "FROM hb_patient_caregiver_internal ci " +
                        "JOIN hb_user u ON ci.userId = u.userId " +
                        "JOIN hb_patient p ON ci.patientId = p.patientId " +
                        "JOIN hb_hierarchy h ON p.wardId = h.levelId " +
                        "WHERE h.hospitalId = :hospitalId AND ci.userId = :userId",
                resultSetMapping = "CaregiverMapping")
})
@SqlResultSetMapping(
        name = "CaregiverMapping",
        entities = {
                @EntityResult (entityClass = PatientCaregiverInternalEntity.class)
        })
public class PatientCaregiverInternalEntity {

    public static final String SQL_GET_CAREGIVER_BY_USER_AND_HOSPITAL =
            "SELECT ci.id, ci.userId, ci.patientId, ci.thirdPartySource, ci.lastUpdated " +
                    "FROM hb_patient_caregiver_internal ci " +
                    "JOIN hb_user u ON ci.userId = u.userId " +
                    "JOIN hb_patient p ON ci.patientId = p.patientId " +
                    "JOIN hb_hierarchy h ON p.wardId = h.levelId " +
                    "WHERE h.hospitalId = :hospitalId AND ci.userId = :userId";

    public static final String SQL_GET_CAREGIVER_BY_USER =
            "SELECT id FROM hb_patient_caregiver_internal WHERE userId = :userId";

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private PatientEntity patientEntity;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String thirdPartySource;
    private Timestamp lastUpdated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public void setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
    }

    public String getThirdPartySource() {
        return thirdPartySource;
    }

    public void setThirdPartySource(String thirdPartySource) {
        this.thirdPartySource = thirdPartySource;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
