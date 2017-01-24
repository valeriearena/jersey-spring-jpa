package com.heartbeat.service;

import com.heartbeat.persistence.dao.PatientDao;
import com.heartbeat.persistence.dao.UserDao;
import com.heartbeat.persistence.entity.PatientEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by valerie on 1/21/17.
 */
@Service
@Transactional(propagation= Propagation.REQUIRED, rollbackFor = Exception.class)
public class PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class.getName());

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private UserDao userDao;


    public PatientEntity find(int patientId){

        return patientDao.find(patientId);
    }

    public void persist(){

    }

    public void updatePatient(int patientId){

        PatientEntity entity = patientDao.find(patientId);
        entity.setFirstName("valerie2");
        patientDao.merge(entity);
    }

    public void assignPatient(int patientId){

    }

    public void delete(int patientId){

    }

    public PatientEntity findByPatientName(String patientName){

        return patientDao.findByPatientName(patientName);
    }

    public List<PatientEntity> findLabOrders(int patientId){

        return patientDao.findLabOrders(patientId);
    }

}
