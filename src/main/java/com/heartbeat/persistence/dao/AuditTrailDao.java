package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.AuditTrailEntity;
import com.heartbeat.persistence.entity.HierarchyEntity;
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

    public AuditTrailEntity find(Integer id) {
        return em.find(AuditTrailEntity.class, id);
    }

    public void persist(AuditTrailEntity entity){
        em.persist(entity);
    }

    public void merge(HierarchyEntity entity){
        em.merge(entity);
    }

    public void remove(AuditTrailEntity entity){
        em.remove(entity);
    }
}
