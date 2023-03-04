package com.rgv04.hr.domain.job.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.job.controller.model.JobModel;
import com.rgv04.hr.domain.job.model.filter.JobFilter;
import com.rgv04.hr.domain.job.service.JobService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/jobs")
public class JobController {

    private final JobService jobService;

    @GetMapping
    public ResponseEntity<CollectionModel<JobModel>> findAll(JobFilter filter) {
        return ResponseEntity.ok(jobService.findAll(filter));
    }

    @GetMapping("{id}")
    public ResponseEntity<JobModel> findById(@PathVariable String id) {
        return ResponseEntity.ok(jobService.findById(id));
    }

}
