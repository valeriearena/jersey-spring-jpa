package com.heartbeat.service;

import com.heartbeat.persistence.CaregiverDao;
import com.heartbeat.persistence.entity.CaregiverEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by valerie on 1/24/17.
 */
@Service
public class CaregiverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaregiverService.class.getName());

    @Autowired
    private CaregiverDao caregiverDao;

    public CaregiverEntity findNamedNativeByUserAndPatient(int userId, int patientId){
        return caregiverDao.findNamedNativeByUserAndPatient(userId, patientId);
    }

    public List<CaregiverEntity> findNamedNativeByUserAndHospital(int userId, int hospitalId){
        return caregiverDao.findNamedNativeByUserAndHospital(userId, hospitalId);
    }

    public List<CaregiverEntity> findDynamicNativeByUserAndHospital(int userId, int hospitalId){
        return caregiverDao.findDynamicNativeByUserAndHospital(userId, hospitalId);
    }

    public Integer findDynamicNativeByUserAndPatient(int userId, int patientId){
        return caregiverDao.findDynamicNativeByUserAndPatient(userId, patientId);
    }


}
