package com.rgv04.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgv04.hr.model.JobHistory;
import com.rgv04.hr.model.JobHistoryID;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryID> {
    
}
