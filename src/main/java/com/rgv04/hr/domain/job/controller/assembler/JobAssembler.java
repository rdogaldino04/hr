package com.rgv04.hr.domain.job.controller.assembler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;
import com.rgv04.hr.domain.job.controller.model.JobModel;
import com.rgv04.hr.domain.job.model.Job;

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
