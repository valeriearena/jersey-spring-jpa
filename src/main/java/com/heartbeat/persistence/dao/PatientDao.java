package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by valerie on 1/22/17.
 */
@Repository
public class PatientDao{

    @PersistenceContext
    private EntityManager em;

    public PatientEntity find(Integer id) {
        return em.find(PatientEntity.class, id);
    }

    public void persist(PatientEntity entity){
        em.persist(entity);
    }

    public void merge(PatientEntity entity){
        em.merge(entity);
    }

    public void remove(PatientEntity entity){
        em.remove(entity);
    }

    public void throwRuntimeException(){
        throw new RuntimeException("test");
    }
}
