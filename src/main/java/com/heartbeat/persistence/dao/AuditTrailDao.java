package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.AuditTrailEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by valerie on 1/24/17.
 */
@Repository
@Transactional(propagation= Propagation.REQUIRED)
public class AuditTrailDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(AuditTrailEntity entity){
        em.persist(entity);
    }
}
