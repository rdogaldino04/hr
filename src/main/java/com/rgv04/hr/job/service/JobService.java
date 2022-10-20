package com.rgv04.hr.job.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rgv04.hr.job.model.Job;
import com.rgv04.hr.job.model.filter.JobFilter;
import com.rgv04.hr.job.repository.JobRepository;
import com.rgv04.hr.job.spec.JobSpecs;
import com.rgv04.hr.service.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JobService {

    private final JobRepository jobRepository;

    public List<Job> findAll(JobFilter filter) {
        return this.jobRepository.findAll(JobSpecs.getSpecs(filter));
    }

    public Job findById(String id) {
        return this.jobRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Entity not found"));
    }
    
}
