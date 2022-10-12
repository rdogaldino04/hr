package com.rgv04.hr.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rgv04.hr.model.JobHistory;
import com.rgv04.hr.model.JobHistoryPK;
import com.rgv04.hr.repository.JobHistoryRepository;
import com.rgv04.hr.service.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JobHistoryService {

    private final JobHistoryRepository jobHistoryRepository;

    public List<JobHistory> findAll() {
        return this.jobHistoryRepository.findAll();
    }
    
    public JobHistory findById(Long employeeId, String startDate) {
        JobHistoryPK jobHistoryPK = new JobHistoryPK(employeeId, OffsetDateTime.parse(startDate));
        return this.jobHistoryRepository.findById(jobHistoryPK)
            .orElseThrow(() -> new BusinessException("Resource not found"));
    }
    
}
