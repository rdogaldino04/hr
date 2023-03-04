package com.rgv04.hr.domain.job.service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.job.controller.assembler.JobAssembler;
import com.rgv04.hr.domain.job.controller.model.JobModel;
import com.rgv04.hr.domain.job.model.filter.JobFilter;
import com.rgv04.hr.domain.job.repository.JobRepository;
import com.rgv04.hr.domain.job.spec.JobSpecs;
import com.rgv04.hr.exception.BusinessException;

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
