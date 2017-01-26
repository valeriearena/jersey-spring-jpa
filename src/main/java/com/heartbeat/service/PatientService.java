package com.heartbeat.service;

import com.heartbeat.persistence.dao.PatientDao;
import com.heartbeat.persistence.entity.PatientEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by valerie on 1/21/17.
 */
@Service
public class PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class.getName());

    @Autowired
    private PatientDao patientDao;

    public PatientEntity find(int patientId) {

        return patientDao.find(patientId);
    }

}
