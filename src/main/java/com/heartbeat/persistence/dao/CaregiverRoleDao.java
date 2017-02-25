package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.CaregiverRoleEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by valerie on 2/25/17.
 */
@Repository
public class CaregiverRoleDao {

    @PersistenceContext
    private EntityManager em;

    public CaregiverRoleEntity find(Integer levelId) {
        return em.find(CaregiverRoleEntity.class, levelId);
    }

    public void persist(CaregiverRoleEntity entity){
        em.persist(entity);
    }

    public void merge(CaregiverRoleEntity entity){
        em.merge(entity);
    }

    public void remove(CaregiverRoleEntity entity){
        em.remove(entity);
    }
}
