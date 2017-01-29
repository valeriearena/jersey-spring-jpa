package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.PatientCaregiverInternalEntity;
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
public class PatientCaregiverInternalDao {

    @PersistenceContext
    private EntityManager em;

    public PatientCaregiverInternalEntity find(Integer levelId) {
        return em.find(PatientCaregiverInternalEntity.class, levelId);
    }

    public void persist(PatientCaregiverInternalEntity entity){
        em.persist(entity);
    }

    public void merge(PatientCaregiverInternalEntity entity){
        em.merge(entity);
    }

    public void remove(PatientCaregiverInternalEntity entity){
        em.remove(entity);
    }

    public PatientCaregiverInternalEntity  findNamedNativeByUserAndPatient(int userId, int patientId){
        TypedQuery<PatientCaregiverInternalEntity> query = em.createNamedQuery(PatientCaregiverInternalEntity.NAMED_NATIVE_CAREGIVER_FIND_BY_USER_AND_PATIENT, PatientCaregiverInternalEntity.class);
        query.setParameter("userId",  userId);
        query.setParameter("patientId",  patientId);
        return query.getSingleResult();
    }

    public List<PatientCaregiverInternalEntity>  findNamedNativeByUserAndHospital(int userId, int hospitalId){
        TypedQuery<PatientCaregiverInternalEntity> query  = em.createNamedQuery(PatientCaregiverInternalEntity.NAMED_NATIVE_CAREGIVER_FIND_BY_USER_AND_HOSPITAL, PatientCaregiverInternalEntity.class);
        query.setParameter("userId",  userId);
        query.setParameter("hospitalId",  hospitalId);
        return query.getResultList();
    }

    public List<PatientCaregiverInternalEntity> findDynamicNativeByUserAndHospital(int userId, int hospitalId){
        Query query = em.createNativeQuery(PatientCaregiverInternalEntity.DYNAMIC_NATIVE_CAREGIVER_FIND_BY_USER_AND_HOSPITAL, PatientCaregiverInternalEntity.class);
        query.setParameter("userId",  userId);
        query.setParameter("hospitalId", hospitalId);
        return query.getResultList();
    }

    public Integer findDynamicNativeByUserAndPatient(int userId, int patientId){
        Query query = em.createNativeQuery(PatientCaregiverInternalEntity.DYNAMIC_NATIVE_CAREGIVER_FIND_BY_USER_AND_PATIENT);
        query.setParameter("userId", userId);
        query.setParameter("patientId",  patientId);
        return (Integer) query.getSingleResult();
    }
}
