package com.heartbeat.persistence.repository;

import com.heartbeat.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by valerie on 1/24/17.
 */

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName")
    UserEntity findByUserName(String userName);

}