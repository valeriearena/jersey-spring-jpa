package com.heartbeat.persistence;

import com.heartbeat.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created by valerie on 1/26/17.
 */
@Repository
@Transactional(propagation= Propagation.REQUIRED)
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public UserEntity find(Integer id) {
        return em.find(UserEntity.class, id);
    }

    public void persist(UserEntity entity){
        em.persist(entity);
    }

    public void merge(UserEntity entity){
        em.merge(entity);
    }

    public void remove(UserEntity entity){
        em.remove(entity);
    }

    public UserEntity findByUserName(String userName){
        TypedQuery<UserEntity> query  = em.createNamedQuery(UserEntity.USER_FIND_BY_USER_NAME, UserEntity.class);
        query.setParameter("userName",  userName);
        return query.getSingleResult();
    }

    public UserEntity findAssignments(int userId){
        TypedQuery<UserEntity> query  = em.createNamedQuery(UserEntity.USER_FIND_ASSIGNMENTS, UserEntity.class);
        query.setParameter("userId",  userId);
        return query.getSingleResult();
    }

    public Integer findUserCount(String likeUserName){

        Query query = em.createNamedQuery(UserEntity.USER_FIND_COUNT);
        query.setParameter("likeUserName",  likeUserName + "%");
        return ((Long)query.getSingleResult()).intValue();
    }

}
