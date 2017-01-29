package com.heartbeat.persistence.dao;

import com.heartbeat.persistence.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by valerie on 1/29/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindByUserName() throws Exception {

        UserEntity entity = userDao.findByUserName("val1");
        assertEquals("Val1 Arena", entity.getName());
    }

    @Test
    public void testFindUserCount(){

        int count = userDao.findUserCount("val");
        assertEquals(11, count);
    }
}