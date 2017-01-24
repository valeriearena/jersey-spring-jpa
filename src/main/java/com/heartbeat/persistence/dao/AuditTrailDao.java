package com.heartbeat.persistence.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by valerie on 1/24/17.
 */
@Repository
public class AuditTrailDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(AuditTrailDao entity){
        em.persist(entity);
    }
}
