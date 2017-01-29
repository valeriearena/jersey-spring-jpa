package com.heartbeat.service;

import com.heartbeat.persistence.HierarchyDao;
import com.heartbeat.persistence.UserDao;
import com.heartbeat.persistence.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by valerie on 1/26/17.
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HierarchyService.class.getName());

    @Autowired
    private UserDao userDao;

    @Autowired
    private HierarchyDao hierarchyDao;

    public UserEntity find(int userId){

        return userDao.find(userId);
    }

    public void updateUserOnBreak(int userId) {

        UserEntity userEntity = userDao.find(userId);
        userEntity.setCustomOnlineStatusMessage("ON BREAK");

        userDao.merge(userEntity);

    }

    public void updateUserOffBreak(int userId) {

        UserEntity userEntity = userDao.find(userId);
        userEntity.setCustomOnlineStatusMessage("");

        userDao.merge(userEntity);
    }

    public UserEntity findByUserName(String userName) {

        return userDao.findByUserName(userName);
    }

    public UserEntity findAssignments(int userId){
        return userDao.findAssignments(userId);

    }
    public Integer findCount(String likeUserName){

        return userDao.findUserCount(likeUserName);
    }

}
