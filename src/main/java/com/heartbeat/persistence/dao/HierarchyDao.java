package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.HierarchyEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    private static final String SQL = "HierarchyEntity.findRootHierarchy";

    @PersistenceContext
    private EntityManager em;

    @Transactional(propagation= Propagation.REQUIRED, readOnly = true)
    public HierarchyEntity find(Integer levelId) {
        return em.find(HierarchyEntity.class, levelId);
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public void persist(HierarchyEntity entity){
        em.persist(entity);
    }

    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = Exception.class)
    public void merge(HierarchyEntity entity){
        em.merge(entity);
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public void remove(HierarchyEntity entity){
        em.remove(entity);
    }

    @Transactional(propagation= Propagation.REQUIRED, readOnly = true)
    public List<HierarchyEntity> findAll(){
        Query query  = em.createNamedQuery(HierarchyEntity.HIERARCHY_FIND_ALL);
        return query.getResultList();
    }

    @Transactional(propagation= Propagation.REQUIRED, readOnly = true)
    public List<HierarchyEntity> findRootHierarchy(){
        TypedQuery<HierarchyEntity> query  = em.createNamedQuery(HierarchyEntity.HIERARCHY_FIND_ROOT, HierarchyEntity.class);
        return query.getResultList();
    }


    public List<HierarchyEntity> findHierarchyImmediateChildren(int parentId){
        TypedQuery<HierarchyEntity> query  = em.createNamedQuery(HierarchyEntity.HIERARCY_FIND_CHILDREN, HierarchyEntity.class);
        query.setParameter("parentId",  parentId);
        return query.getResultList();
    }

}
