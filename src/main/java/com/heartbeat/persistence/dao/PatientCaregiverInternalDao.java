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

    public List<PatientCaregiverInternalEntity>  findByUserAndHospitalNamedQuery(int hospitalId, int userId){
        TypedQuery<PatientCaregiverInternalEntity> query  = em.createNamedQuery("PatientCaregiverInternalEntity.findByUserAndHospital", PatientCaregiverInternalEntity.class);
        query.setParameter("hospitalId",  hospitalId);
        query.setParameter("userId",  userId);
        return query.getResultList();
    }

    public List<PatientCaregiverInternalEntity> findByUserAndHospitalDynamicQuery(int hospitalId, int userId){
        Query q = em.createNativeQuery(PatientCaregiverInternalEntity.SQL_GET_CAREGIVER_BY_USER_AND_HOSPITAL,
                        PatientCaregiverInternalEntity.class);
        q.setParameter("hospitalId", hospitalId);
        q.setParameter("userId", userId);
        return q.getResultList();
    }

    public Integer findCaregiverIdByUserDynamicQuery(int userId){
        Query q = em.createNativeQuery(PatientCaregiverInternalEntity.SQL_GET_CAREGIVER_BY_USER);
        q.setParameter("userId", userId);
        return (Integer) q.getSingleResult();
    }
}
