package com.heartbeat.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by valerie on 1/23/17.
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id") //400 Bad Request: Jackson won't serialize self-ref
@Entity
@Table(name = "hb_hierarchy")
@NamedQueries({
        @NamedQuery(name="HierarchyEntity.findAll",
                query="SELECT h FROM HierarchyEntity h WHERE h.deleted = 0"),
        @NamedQuery(name="HierarchyEntity.findRootHierarchy",
                query="SELECT h FROM HierarchyEntity h WHERE h.parent.levelId = 0 AND h.deleted = 0"),
        @NamedQuery(name="HierarchyEntity.findHierarchyImmediateChildren",
                query="SELECT h FROM HierarchyEntity h WHERE h.parent.levelId = :parentId AND h.deleted = 0 ORDER BY h.levelId"),
})
public class HierarchyEntity {

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "parentId")
    private HierarchyEntity parent;

    @Id
    private Integer levelId;

    @Column(name="levelName")
    private String levelName;

    @Column(name="levelType")
    private String levelType;

    @Column(name="subType")
    private String subType;

    @Column(name="abbreviation")
    private String abbreviation;

    @Column(name="startIndex")
    private Integer startIndex;

    @Column(name="endIndex")
    private Integer endIndex;

    @Column(name="hospitalId")
    private Integer hospitalId;

    @Column(name="colorCode")
    private String colorCode;

    @Column(name="isActive")
    private Integer isActive;

    @Column(name="massDischarge")
    private Integer massDischarge;

    @Column(name="clientLicenseId")
    private String clientLicenseId;

    @Column(name="deleted")
    private Integer deleted;

    public HierarchyEntity getParent() {
        return parent;
    }

    public void setParent(HierarchyEntity parent) {
        this.parent = parent;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getMassDischarge() {
        return massDischarge;
    }

    public void setMassDischarge(Integer massDischarge) {
        this.massDischarge = massDischarge;
    }

    public String getClientLicenseId() {
        return clientLicenseId;
    }

    public void setClientLicenseId(String clientLicenseId) {
        this.clientLicenseId = clientLicenseId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
