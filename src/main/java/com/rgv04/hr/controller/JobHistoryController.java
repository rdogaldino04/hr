package com.rgv04.hr.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.model.JobHistory;
import com.rgv04.hr.service.JobHistoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("jobHistorys")
public class JobHistoryController {

    private final JobHistoryService jobHistoryService;
    
    @GetMapping
    public ResponseEntity<List<JobHistory>> findAll() {
        return ResponseEntity.ok(jobHistoryService.findAll());
    }

    @GetMapping("jobs")
    public ResponseEntity<JobHistory> findById(@RequestParam(required = true) Long employeeId,
            @RequestParam(required = true) String startDate) {        
        return ResponseEntity.ok(jobHistoryService.findById(employeeId, startDate));
    }

}
