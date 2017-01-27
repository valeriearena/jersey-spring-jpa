package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.PatientCaregiverInternalEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public List<PatientCaregiverInternalEntity>  findByUserAndHospitalNamedQuery(int hospitalId, int userId){
        Query query  = em.createNamedQuery(PatientCaregiverInternalEntity.CAREGIVER_FIND_BY_USER_AND_HOSPITAL);
        query.setParameter("hospitalId",  hospitalId);
        query.setParameter("userId",  userId);
        return query.getResultList();
    }

    public List<PatientCaregiverInternalEntity> findByHospitalDynamicQuery(int hospitalId){
        Query q = em.createNativeQuery(PatientCaregiverInternalEntity.CAREGIVER_FIND_BY_HOSPITAL, PatientCaregiverInternalEntity.class);
        q.setParameter("hospitalId", hospitalId);
        return q.getResultList();
    }

    public Integer findCaregiverIdByUserDynamicQuery(int userId){
        Query q = em.createNativeQuery(PatientCaregiverInternalEntity.CAREGIVER_FIND_BY_USER);
        q.setParameter("userId", userId);
        return (Integer) q.getSingleResult();
    }
}
