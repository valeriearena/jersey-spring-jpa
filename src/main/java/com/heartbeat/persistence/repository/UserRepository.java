package com.heartbeat.persistence.repository;

import com.heartbeat.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by valerie on 1/24/17.
 */

public interface UserRepository extends JpaRepository<UserEntity, Integer> {}