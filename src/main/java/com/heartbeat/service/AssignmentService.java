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

import java.util.Iterator;

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

    public void assignPatient(int userId, int patientId){

        UserEntity userEntity = userDao.find(userId);
        PatientEntity patientEntity = patientDao.find(patientId);

        PatientCaregiverInternalEntity caregiverEntity = new PatientCaregiverInternalEntity();
        caregiverEntity.setThirdPartySource("MH_STAFF_ASSIGNMENTS");

        caregiverEntity.setUserEntity(userEntity);
        caregiverEntity.setPatientEntity(patientEntity);

        caregiverInternalDao.persist(caregiverEntity);

        AuditTrailEntity auditTrailEntity = new AuditTrailEntity();
        auditTrailEntity.setActionName(AuditTrailEntity.AuditTrailEnum.UPDATE_PATIENT);
        auditTrailEntity.setUserName(userEntity.getUserName());
        auditTrailEntity.setRoleName(userEntity.getRoleName());
        auditTrailEntity.setPatientId(patientEntity.getPatientId());
        auditTrailEntity.setWardId(patientEntity.getHierarchyEntity().getLevelId());
        auditTrailEntity.setActionValue1(patientEntity.getPatientName());
        auditTrailDao.persist(auditTrailEntity);

    }

    public void unassignPatient(int userId, int patientId){

        UserEntity userEntity = userDao.find(userId);
        PatientEntity patientEntity = patientDao.find(patientId);

        Iterator<PatientCaregiverInternalEntity> iterator = patientEntity.getCaregivers().iterator();
        PatientCaregiverInternalEntity caregiverToUnassign = null;

        while (iterator.hasNext()){
            caregiverToUnassign = iterator.next();
            if(iterator.next().getUserEntity().getUserId() == userId){
                //iterator.remove();
                break;
            }
        }
        caregiverInternalDao.remove(caregiverToUnassign);

        AuditTrailEntity auditTrailEntity = new AuditTrailEntity();
        auditTrailEntity.setActionName(AuditTrailEntity.AuditTrailEnum.UPDATE_PATIENT);
        auditTrailEntity.setUserName(userEntity.getUserName());
        auditTrailEntity.setRoleName(userEntity.getRoleName());
        auditTrailEntity.setPatientId(patientEntity.getPatientId());
        auditTrailEntity.setWardId(patientEntity.getHierarchyEntity().getLevelId());
        auditTrailEntity.setActionValue1(patientEntity.getPatientName());
        auditTrailDao.persist(auditTrailEntity);
    }

    public boolean throwPersistenceExceptionExample(int userId, int patientId){

        try {

            UserEntity userEntity = userDao.find(userId);
            userEntity.setFirstName("test");
            userDao.merge(userEntity);

            PatientEntity patientEntity = patientDao.find(patientId);
            patientEntity.setFirstName("test");
            patientDao.merge(patientEntity);

            patientDao.throwRuntimeException();

            return true;
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }

    }
}
