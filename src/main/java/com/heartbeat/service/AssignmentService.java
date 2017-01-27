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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation= Propagation.REQUIRED)
    public boolean assignPatient(int userId, int patientId){

        try {

            UserEntity userEntity = userDao.find(userId);
            PatientEntity patientEntity = patientDao.find(patientId);

            PatientCaregiverInternalEntity caregiverEntity = new PatientCaregiverInternalEntity();
            caregiverEntity.setThirdPartySource("MH_STAFF_ASSIGNMENTS");

            caregiverEntity.setUserEntity(userEntity);
            caregiverEntity.setPatientEntity(patientEntity);

            caregiverInternalDao.persist(caregiverEntity);

            AuditTrailEntity auditTrailEntity = buildAudit(userEntity, patientEntity, AuditTrailEntity.AuditTrailEnum.UPDATE_PATIENT);
            auditTrailDao.persist(auditTrailEntity);

            return true;
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Transactional(propagation= Propagation.REQUIRED)
    public boolean unassignPatient(int userId, int patientId){

        try {
            UserEntity userEntity = userDao.find(userId);
            PatientEntity patientEntity = patientDao.find(patientId);

            for (PatientCaregiverInternalEntity caregiverInternalEntity : patientEntity.getCaregivers()) {
                if (caregiverInternalEntity.getUserEntity().getUserId() == userId) {
                    userEntity.getAssignments().remove(caregiverInternalEntity);
                    userDao.merge(userEntity);
                    userDao.flush();

                    //patientEntity.getCaregivers().remove(caregiverInternalEntity);
                    //patientDao.merge(patientEntity);

                    //caregiverInternalDao.remove(caregiverInternalEntity);
                    //caregiverInternalDao.merge(patientEntity);

                    AuditTrailEntity auditTrailEntity = buildAudit(userEntity, patientEntity, AuditTrailEntity.AuditTrailEnum.UPDATE_PATIENT);
                    auditTrailDao.persist(auditTrailEntity);

                    break;
                }
            }


            return true;
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    private AuditTrailEntity buildAudit(UserEntity userEntity, PatientEntity patientEntity, AuditTrailEntity.AuditTrailEnum action){

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
