package com.heartbeat.service;

import com.heartbeat.persistence.dao.PatientCaregiverInternalDao;
import com.heartbeat.persistence.entity.PatientCaregiverInternalEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by valerie on 1/24/17.
 */
@Service
public class PatientCaregiverInternalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientCaregiverInternalService.class.getName());

    @Autowired
    private PatientCaregiverInternalDao patientCaregiverInternalDao;

    public PatientCaregiverInternalEntity findNamedNativeByUserAndPatient(int userId, int patientId){
        return patientCaregiverInternalDao.findNamedNativeByUserAndPatient(userId, patientId);
    }

    public List<PatientCaregiverInternalEntity> findNamedNativeByUserAndHospital(int userId, int hospitalId){
        return patientCaregiverInternalDao.findNamedNativeByUserAndHospital(userId, hospitalId);
    }

    public List<PatientCaregiverInternalEntity> findDynamicNativeByUserAndHospital(int userId, int hospitalId){
        return patientCaregiverInternalDao.findDynamicNativeByUserAndHospital(userId, hospitalId);
    }

    public Integer findDynamicNativeByUserAndPatient(int userId, int patientId){
        return patientCaregiverInternalDao.findDynamicNativeByUserAndPatient(userId, patientId);
    }


}
