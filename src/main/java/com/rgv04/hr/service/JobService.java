package com.rgv04.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rgv04.hr.repository.JobRepository;
import com.rgv04.hr.service.exception.BusinessException;

import lombok.RequiredArgsConstructor;
import com.rgv04.hr.model.Job;

@RequiredArgsConstructor
@Service
public class JobService {

    private final JobRepository jobRepository;

    public List<Job> findAll() {
        return this.jobRepository.findAll();
    }

    public Job findById(String id) {
        return this.jobRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Entity not found"));
    }
    
}
