package com.heartbeat.service;

import com.heartbeat.persistence.dao.HierarchyDao;
import com.heartbeat.persistence.entity.HierarchyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by valerie on 1/23/17.
 */
@Service
public class HierarchyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HierarchyService.class.getName());

    @Autowired
    private HierarchyDao hierarchyDao;

    public HierarchyEntity getHierarchy(int levelId){
        return hierarchyDao.find(levelId);
    }

    public List<HierarchyEntity> getAll(){
        return hierarchyDao.findAll();
    }

    public List<HierarchyEntity> getRootHierarchy(){
        return hierarchyDao.findRootHierarchy();
    }

    public List<HierarchyEntity> getHierarchyImmediateChildren(int levelId){
        return hierarchyDao.findHierarchyImmediateChildren(levelId);
    }


}

