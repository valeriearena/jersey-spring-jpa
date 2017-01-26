package com.heartbeat.persistence.repository;

import com.heartbeat.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by valerie on 1/26/17.
 */
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {}