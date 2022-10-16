package com.rgv04.hr.controller.assembler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.controller.model.JobModel;
import com.rgv04.hr.model.Job;

@Component
public class JobAssembler implements Assembler<Job, JobModel> {

    @Override
    public List<JobModel> toListModel(List<Job> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JobModel toModel(Job entity) {
        return JobModel.builder()
            .id(entity.getId())
            .title(entity.getTitle())
            .minSalary(entity.getMinSalary())
            .maxSalary(entity.getMaxSalary())
            .build();        
    }
    
}
