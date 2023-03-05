package com.rgv04.hr.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.rgv04.hr.domain.model.Job;

public interface JobRepository extends JpaRepository<Job, String>, JpaSpecificationExecutor<Job> {

}
