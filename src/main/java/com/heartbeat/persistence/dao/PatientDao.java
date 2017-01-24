package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public PatientEntity findByPatientName(String patientName){
        TypedQuery<PatientEntity> query  = em.createNamedQuery("PatientEntity.findByPatientName", PatientEntity.class);
        query.setParameter("patientName",  patientName);
        return query.getSingleResult();
    }


    public List<PatientEntity> findLabOrders(int patientId){
        TypedQuery<PatientEntity> query  = em.createNamedQuery("PatientEntity.findLabOrders", PatientEntity.class);
        query.setParameter("patientId",  patientId);
        return query.getResultList();
    }

}
