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

    @Id
    private Integer levelId;

    private String levelName;
    private String levelType;
    private String subType;
    private String abbreviation;
    private Integer startIndex;
    private Integer endIndex;
    private Integer hospitalId;
    private String colorCode;
    private Integer isActive;
    private Integer massDischarge;
    private String clientLicenseId;
    private Integer deleted;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "parentId")
    private HierarchyEntity parent;

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

    public HierarchyEntity getParent() {
        return parent;
    }

    public void setParent(HierarchyEntity parent) {
        this.parent = parent;
    }
}
