package com.heartbeat.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by valerie on 1/24/17.
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id") //400 Bad Request: Jackson won't serialize self-ref
@Entity
@Table(name = "hb_patient_caregiver_internal")
@NamedNativeQueries({
        @NamedNativeQuery(name="PatientCaregiverInternalEntity.findByUserAndPatient",
                query="SELECT id, userId, patientId, thirdPartySource, lastUpdated " +
                        "FROM hb_patient_caregiver_internal " +
                        "WHERE userId = :userId AND patientId = :patientId",
                resultClass = PatientCaregiverInternalEntity.class),
        @NamedNativeQuery(name="PatientCaregiverInternalEntity.findByUserAndHospital",
                query="SELECT c.id, c.userId, c.patientId, c.thirdPartySource, c.lastUpdated " +
                        "FROM hb_patient_caregiver_internal c " +
                        "JOIN hb_user u ON c.userId = u.userId " +
                        "JOIN hb_patient p ON c.patientId = p.patientId " +
                        "JOIN hb_hierarchy h ON p.wardId = h.levelId " +
                        "WHERE c.userId = :userId AND h.hospitalId = :hospitalId",
                resultClass = PatientCaregiverInternalEntity.class)
})
public class PatientCaregiverInternalEntity {

    public static final String NAMED_NATIVE_CAREGIVER_FIND_BY_USER_AND_PATIENT= "PatientCaregiverInternalEntity.findByUserAndPatient";
    public static final String NAMED_NATIVE_CAREGIVER_FIND_BY_USER_AND_HOSPITAL = "PatientCaregiverInternalEntity.findByUserAndHospital";

    public static final String DYNAMIC_NATIVE_CAREGIVER_FIND_BY_USER_AND_HOSPITAL =
            "SELECT c.id, c.userId, c.patientId, c.thirdPartySource, c.lastUpdated " +
                    "FROM hb_patient_caregiver_internal c " +
                    "JOIN hb_user u ON c.userId = u.userId " +
                    "JOIN hb_patient p ON c.patientId = p.patientId " +
                    "JOIN hb_hierarchy h ON p.wardId = h.levelId " +
                    "WHERE c.userId = :userId AND h.hospitalId = :hospitalId";

    public static final String DYNAMIC_NATIVE_CAREGIVER_FIND_BY_USER_AND_PATIENT =
            "SELECT id FROM hb_patient_caregiver_internal WHERE userId = :userId AND patientId = :patientId";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String thirdPartySource;
    private Date lastUpdated = new Date();

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private PatientEntity patientEntity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThirdPartySource() {
        return thirdPartySource;
    }

    public void setThirdPartySource(String thirdPartySource) {
        this.thirdPartySource = thirdPartySource;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
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
}
