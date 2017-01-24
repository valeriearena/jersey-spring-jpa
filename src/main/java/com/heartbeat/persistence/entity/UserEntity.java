package com.heartbeat.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by valerie on 1/24/17.
 */
@Entity
@Table(name = "hb_user")
public class UserEntity {

    @OneToMany(mappedBy="userEntity", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<PatientCaregiverInternalEntity> caregivers;

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private HierarchyEntity hierarchyEntity;

    @Id
    private Integer userId;
    private String userName;
    private String imId;
    private String password;
    private String unlockCode;
    private String sipUsername;
    private String sipExtensionPW;
    private String roleName;
    private String sysRoleName;
    private Integer isInternal;
    private String externalPhoneNumber;
    private String accessCardNumber;
    private String accessCardNumberMasked;
    private String name;
    private String heartbeatPhoneNumber;
    private String email;
    private Date lastLoginTime;
    private String customOnlineStatusMessage;
    private String pagerNumber;
    private Integer deleted;
    private Integer isLastDeviceTurnkey;
    private Integer customOnlineStatus;
    private Integer newUser;
    private Integer mustResetUnlockCode;
    private Date lastUpdateDateTime;
    private Date lastSyncUpdateDateTime;
    private Integer isMuted;
    private Integer hasAcceptedTermsAndConditions;
    private String ldapUniqueId;
    private Date lastLdapSync;
    private Integer preventLdapSync;
    private Integer pendingDeletion;
    private String firstName;
    private String lastName;
    private String initials;
    private String title;
    private String department;
    private String company;

    public List<PatientCaregiverInternalEntity> getCaregivers() {
        return caregivers;
    }

    public void setCaregivers(List<PatientCaregiverInternalEntity> caregivers) {
        this.caregivers = caregivers;
    }

    public HierarchyEntity getHierarchyEntity() {
        return hierarchyEntity;
    }

    public void setHierarchyEntity(HierarchyEntity hierarchyEntity) {
        this.hierarchyEntity = hierarchyEntity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUnlockCode() {
        return unlockCode;
    }

    public void setUnlockCode(String unlockCode) {
        this.unlockCode = unlockCode;
    }

    public String getSipUsername() {
        return sipUsername;
    }

    public void setSipUsername(String sipUsername) {
        this.sipUsername = sipUsername;
    }

    public String getSipExtensionPW() {
        return sipExtensionPW;
    }

    public void setSipExtensionPW(String sipExtensionPW) {
        this.sipExtensionPW = sipExtensionPW;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName;
    }

    public Integer getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(Integer isInternal) {
        this.isInternal = isInternal;
    }

    public String getExternalPhoneNumber() {
        return externalPhoneNumber;
    }

    public void setExternalPhoneNumber(String externalPhoneNumber) {
        this.externalPhoneNumber = externalPhoneNumber;
    }

    public String getAccessCardNumber() {
        return accessCardNumber;
    }

    public void setAccessCardNumber(String accessCardNumber) {
        this.accessCardNumber = accessCardNumber;
    }

    public String getAccessCardNumberMasked() {
        return accessCardNumberMasked;
    }

    public void setAccessCardNumberMasked(String accessCardNumberMasked) {
        this.accessCardNumberMasked = accessCardNumberMasked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeartbeatPhoneNumber() {
        return heartbeatPhoneNumber;
    }

    public void setHeartbeatPhoneNumber(String heartbeatPhoneNumber) {
        this.heartbeatPhoneNumber = heartbeatPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getCustomOnlineStatusMessage() {
        return customOnlineStatusMessage;
    }

    public void setCustomOnlineStatusMessage(String customOnlineStatusMessage) {
        this.customOnlineStatusMessage = customOnlineStatusMessage;
    }

    public String getPagerNumber() {
        return pagerNumber;
    }

    public void setPagerNumber(String pagerNumber) {
        this.pagerNumber = pagerNumber;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getIsLastDeviceTurnkey() {
        return isLastDeviceTurnkey;
    }

    public void setIsLastDeviceTurnkey(Integer isLastDeviceTurnkey) {
        this.isLastDeviceTurnkey = isLastDeviceTurnkey;
    }

    public Integer getCustomOnlineStatus() {
        return customOnlineStatus;
    }

    public void setCustomOnlineStatus(Integer customOnlineStatus) {
        this.customOnlineStatus = customOnlineStatus;
    }

    public Integer getNewUser() {
        return newUser;
    }

    public void setNewUser(Integer newUser) {
        this.newUser = newUser;
    }

    public Integer getMustResetUnlockCode() {
        return mustResetUnlockCode;
    }

    public void setMustResetUnlockCode(Integer mustResetUnlockCode) {
        this.mustResetUnlockCode = mustResetUnlockCode;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public Date getLastSyncUpdateDateTime() {
        return lastSyncUpdateDateTime;
    }

    public void setLastSyncUpdateDateTime(Date lastSyncUpdateDateTime) {
        this.lastSyncUpdateDateTime = lastSyncUpdateDateTime;
    }

    public Integer getIsMuted() {
        return isMuted;
    }

    public void setIsMuted(Integer isMuted) {
        this.isMuted = isMuted;
    }

    public Integer getHasAcceptedTermsAndConditions() {
        return hasAcceptedTermsAndConditions;
    }

    public void setHasAcceptedTermsAndConditions(Integer hasAcceptedTermsAndConditions) {
        this.hasAcceptedTermsAndConditions = hasAcceptedTermsAndConditions;
    }

    public String getLdapUniqueId() {
        return ldapUniqueId;
    }

    public void setLdapUniqueId(String ldapUniqueId) {
        this.ldapUniqueId = ldapUniqueId;
    }

    public Date getLastLdapSync() {
        return lastLdapSync;
    }

    public void setLastLdapSync(Date lastLdapSync) {
        this.lastLdapSync = lastLdapSync;
    }

    public Integer getPreventLdapSync() {
        return preventLdapSync;
    }

    public void setPreventLdapSync(Integer preventLdapSync) {
        this.preventLdapSync = preventLdapSync;
    }

    public Integer getPendingDeletion() {
        return pendingDeletion;
    }

    public void setPendingDeletion(Integer pendingDeletion) {
        this.pendingDeletion = pendingDeletion;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
