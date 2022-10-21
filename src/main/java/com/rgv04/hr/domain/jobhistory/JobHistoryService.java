package com.rgv04.hr.domain.jobhistory;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rgv04.hr.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JobHistoryService {

    private final JobHistoryRepository jobHistoryRepository;

    public List<JobHistory> findAll() {
        return this.jobHistoryRepository.findAll();
    }
    
    public JobHistory findById(Long employeeId, String startDate) {
        JobHistoryID jobHistoryPK = new JobHistoryID(employeeId, OffsetDateTime.parse(startDate));
        return this.jobHistoryRepository.findById(jobHistoryPK)
            .orElseThrow(() -> new BusinessException("Resource not found"));
    }
    
}
