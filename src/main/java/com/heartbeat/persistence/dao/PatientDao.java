package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by valerie on 1/22/17.
 */
@Repository
@Transactional
public class PatientDao{

    @PersistenceContext
    private EntityManager em;

    public PatientEntity find(Integer id) {
        return em.find(PatientEntity.class, id);
    }

}
