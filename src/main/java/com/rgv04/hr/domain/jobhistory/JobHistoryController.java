package com.rgv04.hr.domain.jobhistory;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/jobHistorys")
public class JobHistoryController {

    private final JobHistoryService jobHistoryService;
    private final JobHistoryAssembler jobHistoryAssembler;
    
    @GetMapping
    public ResponseEntity<List<JobHistory>> findAll() {
        return ResponseEntity.ok(jobHistoryService.findAll());
    }

    @GetMapping("jobs")
    public ResponseEntity<JobHistoryModel> findById(@RequestParam(required = true) Long employeeId,
            @RequestParam(required = true) String startDate) {
        return ResponseEntity.ok(this.jobHistoryAssembler.toModel(jobHistoryService.findById(employeeId, startDate)));
    }

}