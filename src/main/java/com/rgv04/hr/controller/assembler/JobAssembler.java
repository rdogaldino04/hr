package com.rgv04.hr.controller.assembler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.model.Job;
import com.rgv04.hr.model.dto.JobDTO;

@Component
public class JobAssembler implements Assembler<Job, JobDTO> {

    @Override
    public List<JobDTO> toListDto(List<Job> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JobDTO toDto(Job entity) {
        return JobDTO.builder()
            .id(entity.getId())
            .title(entity.getTitle())
            .minSalary(entity.getMinSalary())
            .maxSalary(entity.getMaxSalary())
            .build();        
    }
    
}
