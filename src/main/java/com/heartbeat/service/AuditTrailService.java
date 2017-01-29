package com.heartbeat.service;

import com.heartbeat.persistence.AuditTrailDao;
import com.heartbeat.persistence.entity.AuditTrailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by valerie on 1/28/17.
 */
@Service
@Transactional
public class AuditTrailService{

    @Autowired
    private AuditTrailDao auditTrailDao;

    public void remove(int trailId){

        AuditTrailEntity auditTrailEntity = auditTrailDao.find(trailId);
        auditTrailDao.remove(auditTrailEntity);

    }
}
