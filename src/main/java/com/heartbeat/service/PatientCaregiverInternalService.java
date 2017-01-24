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

    public List<PatientCaregiverInternalEntity> findByUserAndHospital(int hospitalId, int userId){
        return patientCaregiverInternalDao.findByUserAndHospital(hospitalId, userId);
    }

    public Integer findCaregiverIdByUser(int userId){
        return patientCaregiverInternalDao.findCaregiverIdByUser(userId);
    }


}
