package com.heartbeat.service;

import com.heartbeat.persistence.dao.UserDao;
import com.heartbeat.persistence.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by valerie on 1/29/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @Before
    public void setUp(){

        UserEntity entity = new UserEntity();
        entity.setUserName("val1");

        when(this.userDao.find(anyInt())).thenReturn(entity);

        when(this.userDao.findByUserName(anyString())).thenReturn(entity);

    }

    @Test
    public void testFind() throws Exception {

        UserEntity entity = userDao.find(100);
        assertEquals("val1", entity.getUserName());

    }

    @Test
    public void testFindByUserName() throws Exception {

        UserEntity entity = userDao.findByUserName("val1");
        assertNotNull(entity.getUserName());

    }
}