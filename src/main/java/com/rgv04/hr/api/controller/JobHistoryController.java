package com.rgv04.hr.api.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.model.JobHistoryModel;
import com.rgv04.hr.domain.service.JobHistoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/jobHistorys")
public class JobHistoryController {

    private final JobHistoryService jobHistoryService;

    @GetMapping
    public ResponseEntity<CollectionModel<JobHistoryModel>> getAll() {
        return ResponseEntity.ok(jobHistoryService.getAll());
    }

    @GetMapping("jobs")
    public ResponseEntity<JobHistoryModel> findById(@RequestParam(required = true) Long employeeId,
            @RequestParam(required = true) String startDate) {
        return ResponseEntity.ok(jobHistoryService.findById(employeeId, startDate));
    }

}
