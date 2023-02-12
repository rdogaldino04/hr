package com.rgv04.hr.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.jobhistory.JobHistory;
import com.rgv04.hr.domain.jobhistory.JobHistoryModel;
import com.rgv04.hr.domain.jobhistory.JobHistoryModelAssembler;
import com.rgv04.hr.domain.jobhistory.JobHistoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/jobHistorys")
public class JobHistoryController {

    private final JobHistoryService jobHistoryService;
    private final JobHistoryModelAssembler jobHistoryAssembler;

    @GetMapping
    public ResponseEntity<CollectionModel<JobHistoryModel>> getAll() {
        List<JobHistory> jobHistories = jobHistoryService.getAll();
        return ResponseEntity.ok(jobHistoryAssembler.toCollectionModel(jobHistories));
    }

    @GetMapping("jobs")
    public ResponseEntity<JobHistoryModel> findById(@RequestParam(required = true) Long employeeId,
            @RequestParam(required = true) String startDate) {
        return ResponseEntity.ok(this.jobHistoryAssembler.toModel(jobHistoryService.findById(employeeId, startDate)));
    }

}
