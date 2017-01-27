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

    private static final String SQL = "HierarchyEntity.findRootHierarchy";

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
        Query query  = em.createNamedQuery(HierarchyEntity.HIERARCHY_FIND_ALL);
        return query.getResultList();
    }

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
