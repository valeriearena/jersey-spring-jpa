package com.heartbeat.persistence;

import com.heartbeat.persistence.entity.CaregiverEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by valerie on 1/24/17.
 */
@Repository
public class CaregiverDao {

    @PersistenceContext
    private EntityManager em;

    public CaregiverEntity find(Integer levelId) {
        return em.find(CaregiverEntity.class, levelId);
    }

    public void persist(CaregiverEntity entity){
        em.persist(entity);
    }

    public void merge(CaregiverEntity entity){
        em.merge(entity);
    }

    public void remove(CaregiverEntity entity){
        em.remove(entity);
    }

    public CaregiverEntity findNamedNativeByUserAndPatient(int userId, int patientId){
        TypedQuery<CaregiverEntity> query = em.createNamedQuery(CaregiverEntity.NAMED_NATIVE_CAREGIVER_FIND_BY_USER_AND_PATIENT, CaregiverEntity.class);
        query.setParameter("userId",  userId);
        query.setParameter("patientId",  patientId);
        return query.getSingleResult();
    }

    public List<CaregiverEntity>  findNamedNativeByUserAndHospital(int userId, int hospitalId){
        TypedQuery<CaregiverEntity> query  = em.createNamedQuery(CaregiverEntity.NAMED_NATIVE_CAREGIVER_FIND_BY_USER_AND_HOSPITAL, CaregiverEntity.class);
        query.setParameter("userId",  userId);
        query.setParameter("hospitalId",  hospitalId);
        return query.getResultList();
    }

    public List<CaregiverEntity> findDynamicNativeByUserAndHospital(int userId, int hospitalId){
        Query query = em.createNativeQuery(CaregiverEntity.DYNAMIC_NATIVE_CAREGIVER_FIND_BY_USER_AND_HOSPITAL, CaregiverEntity.class);
        query.setParameter("userId",  userId);
        query.setParameter("hospitalId", hospitalId);
        return query.getResultList();
    }

    public Integer findDynamicNativeByUserAndPatient(int userId, int patientId){
        Query query = em.createNativeQuery(CaregiverEntity.DYNAMIC_NATIVE_CAREGIVER_FIND_BY_USER_AND_PATIENT);
        query.setParameter("userId", userId);
        query.setParameter("patientId",  patientId);
        return (Integer) query.getSingleResult();
    }
}
