package com.heartbeat.persistence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by valerie on 1/24/17.
 */
@Entity
@Table(name = "hb_patient_lab_orders")
public class PatientLabOrders {

    @Id
    private Integer labOrderId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private PatientEntity patientEntity;

    private String orderNumber;
    private String orderIdentifier;
    private String orderName;
    private Date resultDate;
    private Date orderDate;
    private String resultStatus;
    private String abnormalFlagEnum;
    private String notes;
    private String displayData;
    private String specimenType;
    private String specimenSource;

    public Integer getLabOrderId() {
        return labOrderId;
    }

    public void setLabOrderId(Integer labOrderId) {
        this.labOrderId = labOrderId;
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderIdentifier() {
        return orderIdentifier;
    }

    public void setOrderIdentifier(String orderIdentifier) {
        this.orderIdentifier = orderIdentifier;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getAbnormalFlagEnum() {
        return abnormalFlagEnum;
    }

    public void setAbnormalFlagEnum(String abnormalFlagEnum) {
        this.abnormalFlagEnum = abnormalFlagEnum;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDisplayData() {
        return displayData;
    }

    public void setDisplayData(String displayData) {
        this.displayData = displayData;
    }

    public String getSpecimenType() {
        return specimenType;
    }

    public void setSpecimenType(String specimenType) {
        this.specimenType = specimenType;
    }

    public String getSpecimenSource() {
        return specimenSource;
    }

    public void setSpecimenSource(String specimenSource) {
        this.specimenSource = specimenSource;
    }
}
