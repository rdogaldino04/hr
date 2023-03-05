package com.rgv04.hr.domain.service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.assembler.JobAssembler;
import com.rgv04.hr.domain.dto.JobFilter;
import com.rgv04.hr.domain.dto.JobModel;
import com.rgv04.hr.domain.exception.BusinessException;
import com.rgv04.hr.domain.repository.JobRepository;
import com.rgv04.hr.domain.specs.JobSpecs;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JobService {

    private final JobRepository jobRepository;

    private final JobAssembler jobAssembler;

    public CollectionModel<JobModel> findAll(JobFilter filter) {
        return jobAssembler.toCollectionModel(this.jobRepository.findAll(JobSpecs.getSpecs(filter)));
    }

    public JobModel findById(String id) {
        return jobAssembler.toModel(this.jobRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Entity not found")));
    }

}
