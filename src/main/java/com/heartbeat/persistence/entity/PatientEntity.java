package com.heartbeat.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by valerie on 1/21/17.
 */
@Entity
@Table(name = "hb_patient")
public class PatientEntity {

    @Id
    private Integer patientId;

    private String patientName;
    private String lastName;
    private String firstName;
    private String middleName;
    private String title;
    private String suffixName;
    private Date dateOfBirth;
    private Integer gender;
    private Date creationDate;
    private Integer active;
    private String patientNumber;
    private String hospitalPatientNumber;
    private String bedNumber;
    private Date targetedDischargeTime;
    private Date latestDischargeTime;
    private String alerts;
    private Date lastUpdated;
    private Integer dischargeDestinationId;
    private Integer acuity;
    private String chiefComplaint;
    private Date lastKnownWell;
    private Date wardActivationDate;
    private Integer isConfidential;

    @ManyToOne
    @JoinColumn(name = "wardId")
    private HierarchyEntity hierarchyEntity;

    @OneToMany(mappedBy="patientEntity", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<PatientCaregiverInternalEntity> caregivers;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getHospitalPatientNumber() {
        return hospitalPatientNumber;
    }

    public void setHospitalPatientNumber(String hospitalPatientNumber) {
        this.hospitalPatientNumber = hospitalPatientNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Date getTargetedDischargeTime() {
        return targetedDischargeTime;
    }

    public void setTargetedDischargeTime(Date targetedDischargeTime) {
        this.targetedDischargeTime = targetedDischargeTime;
    }

    public Date getLatestDischargeTime() {
        return latestDischargeTime;
    }

    public void setLatestDischargeTime(Date latestDischargeTime) {
        this.latestDischargeTime = latestDischargeTime;
    }

    public String getAlerts() {
        return alerts;
    }

    public void setAlerts(String alerts) {
        this.alerts = alerts;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getDischargeDestinationId() {
        return dischargeDestinationId;
    }

    public void setDischargeDestinationId(Integer dischargeDestinationId) {
        this.dischargeDestinationId = dischargeDestinationId;
    }

    public Integer getAcuity() {
        return acuity;
    }

    public void setAcuity(Integer acuity) {
        this.acuity = acuity;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public Date getLastKnownWell() {
        return lastKnownWell;
    }

    public void setLastKnownWell(Date lastKnownWell) {
        this.lastKnownWell = lastKnownWell;
    }

    public Date getWardActivationDate() {
        return wardActivationDate;
    }

    public void setWardActivationDate(Date wardActivationDate) {
        this.wardActivationDate = wardActivationDate;
    }

    public Integer getIsConfidential() {
        return isConfidential;
    }

    public void setIsConfidential(Integer isConfidential) {
        this.isConfidential = isConfidential;
    }

    public HierarchyEntity getHierarchyEntity() {
        return hierarchyEntity;
    }

    public void setHierarchyEntity(HierarchyEntity hierarchyEntity) {
        this.hierarchyEntity = hierarchyEntity;
    }

    public List<PatientCaregiverInternalEntity> getCaregivers() {
        return caregivers;
    }

    public void setCaregivers(List<PatientCaregiverInternalEntity> caregivers) {
        this.caregivers = caregivers;
    }

}
