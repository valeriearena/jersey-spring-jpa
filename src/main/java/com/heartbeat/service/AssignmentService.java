package com.heartbeat.service;

import com.heartbeat.persistence.AuditTrailDao;
import com.heartbeat.persistence.CaregiverDao;
import com.heartbeat.persistence.PatientDao;
import com.heartbeat.persistence.UserDao;
import com.heartbeat.persistence.entity.*;
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
    private CaregiverDao caregiverDao;

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

            CaregiverEntity caregiverEntity = new CaregiverEntity();
            caregiverEntity.setThirdPartySource("MH_STAFF_ASSIGNMENTS");

            caregiverEntity.setUserEntity(userEntity);
            caregiverEntity.setPatientEntity(patientEntity);

            CaregiverRoleEntity role = new CaregiverRoleEntity();
            role.setCaregiverEntity(caregiverEntity);
            role.setRoleId(1);

            caregiverDao.persist(caregiverEntity);

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


            CaregiverEntity caregiverEntity = new CaregiverEntity();
            caregiverEntity.setThirdPartySource("MH_STAFF_ASSIGNMENTS");

            caregiverEntity.setUserEntity(userEntity);
            caregiverEntity.setPatientEntity(patientEntity);

            caregiverDao.persist(caregiverEntity);

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
    public boolean assignPatientWithRole(int userId, int patientId) {

        try {
            UserEntity userEntity = userDao.find(userId);
            PatientEntity patientEntity = patientDao.find(patientId);

            CaregiverEntity caregiverEntity = new CaregiverEntity();
            caregiverEntity.setThirdPartySource("MH_STAFF_ASSIGNMENTS");

            caregiverEntity.setUserEntity(userEntity);
            caregiverEntity.setPatientEntity(patientEntity);

            CaregiverRoleEntity role = new CaregiverRoleEntity();
            role.setCaregiverEntity(caregiverEntity);
            role.setRoleId(1);

            caregiverEntity.getRoles().add(role);

            caregiverDao.persist(caregiverEntity);


            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void unassignPatient(int userId, int patientId) {

        CaregiverEntity caregiverInternalEntity = caregiverDao.findNamedNativeByUserAndPatient(userId, patientId);
        caregiverDao.remove(caregiverInternalEntity);

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
