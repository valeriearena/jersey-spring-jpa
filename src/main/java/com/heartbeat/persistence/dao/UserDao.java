package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.PatientEntity;
import com.heartbeat.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by valerie on 1/24/17.
 */
@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public UserEntity find(Integer id) {
        return em.find(UserEntity.class, id);
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
}
