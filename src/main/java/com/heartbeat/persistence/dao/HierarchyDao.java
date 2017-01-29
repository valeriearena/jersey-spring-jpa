package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.HierarchyEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by valerie on 1/23/17.
 */
@Repository
public class HierarchyDao {

    @PersistenceContext
    private EntityManager em;

    public HierarchyEntity find(Integer levelId) {
        return em.find(HierarchyEntity.class, levelId);
    }

    public void persist(HierarchyEntity entity){
        em.persist(entity);
    }

    public void merge(HierarchyEntity entity){
        em.merge(entity);
    }

    public void remove(HierarchyEntity entity){
        em.remove(entity);
    }

    public List<HierarchyEntity> findAll(){
        Query query  = em.createNamedQuery("HierarchyEntity.findAll");
        return query.getResultList();
    }

    public List<HierarchyEntity> findRootHierarchy(){
        TypedQuery<HierarchyEntity> query  = em.createNamedQuery("HierarchyEntity.findRootHierarchy", HierarchyEntity.class);
        return query.getResultList();
    }

    public List<HierarchyEntity> findHierarchyImmediateChildren(int parentId){
        TypedQuery<HierarchyEntity> query  = em.createNamedQuery("HierarchyEntity.findHierarchyImmediateChildren", HierarchyEntity.class);
        query.setParameter("parentId",  parentId);
        return query.getResultList();
    }

}
