package com.heartbeat.service;

import com.heartbeat.persistence.dao.AuditTrailDao;
import com.heartbeat.persistence.dao.PatientCaregiverInternalDao;
import com.heartbeat.persistence.dao.PatientDao;
import com.heartbeat.persistence.dao.UserDao;
import com.heartbeat.persistence.entity.AuditTrailEntity;
import com.heartbeat.persistence.entity.PatientCaregiverInternalEntity;
import com.heartbeat.persistence.entity.PatientEntity;
import com.heartbeat.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

/**
 * Created by valerie on 1/26/17.
 */
@Service
public class AssignmentService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientCaregiverInternalDao caregiverInternalDao;

    @Autowired
    private AuditTrailDao auditTrailDao;

    @Resource
    private JpaTransactionManager transactionManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean assignPatientCmt(int userId, int patientId) {

        try {
            UserEntity userEntity = userDao.find(userId);
            PatientEntity patientEntity = patientDao.find(patientId);

            AuditTrailEntity auditTrailStart = buildAudit(userEntity, patientEntity, AuditTrailEntity.AuditTrailEnum.START_ASSIGNMENT);
            auditTrailDao.persist(auditTrailStart);

            PatientCaregiverInternalEntity caregiverEntity = new PatientCaregiverInternalEntity();
            caregiverEntity.setThirdPartySource("MH_STAFF_ASSIGNMENTS");

            caregiverEntity.setUserEntity(userEntity);
            caregiverEntity.setPatientEntity(patientEntity);

            caregiverInternalDao.persist(caregiverEntity);

            AuditTrailEntity auditTrailEnd = buildAudit(userEntity, patientEntity, AuditTrailEntity.AuditTrailEnum.END_ASSSIGNMENT);
            auditTrailDao.persist(auditTrailEnd);

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean assignPatientBmt(int userId, int patientId) {

        TransactionStatus status = null;
        try {

            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            status = transactionManager.getTransaction(def);

            UserEntity userEntity = userDao.find(userId);
            PatientEntity patientEntity = patientDao.find(patientId);

            AuditTrailEntity auditTrailStart = buildAudit(userEntity, patientEntity, AuditTrailEntity.AuditTrailEnum.START_ASSIGNMENT);
            auditTrailDao.persist(auditTrailStart);


            PatientCaregiverInternalEntity caregiverEntity = new PatientCaregiverInternalEntity();
            caregiverEntity.setThirdPartySource("MH_STAFF_ASSIGNMENTS");

            caregiverEntity.setUserEntity(userEntity);
            caregiverEntity.setPatientEntity(patientEntity);

            caregiverInternalDao.persist(caregiverEntity);

            AuditTrailEntity auditTrailEnd = buildAudit(userEntity, patientEntity, AuditTrailEntity.AuditTrailEnum.END_ASSSIGNMENT);
            auditTrailDao.persist(auditTrailEnd);

            transactionManager.commit(status);

            return true;
        }
        catch (Exception e) {

            transactionManager.rollback(status);
            return false;
        }
        finally {
            try {if(!status.isCompleted()){transactionManager.commit(status);}}
            catch (Exception e) {transactionManager.rollback(status);}
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void unassignPatient(int userId, int patientId) {

        PatientCaregiverInternalEntity caregiverInternalEntity = caregiverInternalDao.findNamedNativeByUserAndPatient(userId, patientId);
        caregiverInternalDao.remove(caregiverInternalEntity);

    }

    private AuditTrailEntity buildAudit(UserEntity userEntity, PatientEntity patientEntity, AuditTrailEntity.AuditTrailEnum action) {

        AuditTrailEntity auditTrailEntity = new AuditTrailEntity();
        auditTrailEntity.setActionName(action);
        auditTrailEntity.setUserName(userEntity.getUserName());
        auditTrailEntity.setRoleName(userEntity.getRoleName());
        auditTrailEntity.setPatientId(patientEntity.getPatientId());
        auditTrailEntity.setWardId(patientEntity.getHierarchyEntity().getLevelId());
        auditTrailEntity.setActionValue1(patientEntity.getPatientName());
        return auditTrailEntity;
    }


}
