package com.rgv04.hr.domain.jobhistory;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;
import com.rgv04.hr.domain.departament.DepartamentAssembler;
import com.rgv04.hr.domain.job.controller.assembler.JobAssembler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JobHistoryAssembler implements Assembler<JobHistory, JobHistoryModel> {

    private final JobAssembler jobAssembler;
    private final DepartamentAssembler departamentAssembler;

    @Override
    public List<JobHistoryModel> toListModel(List<JobHistory> entities) {        
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JobHistoryModel toModel(JobHistory entity) {
        return JobHistoryModel.builder()
                .employeeId(entity.getJobHistoryID().getEmployeeId())
                .startDate(entity.getJobHistoryID().getStartDate())
                .endDate(entity.getEndDate())
                .job(jobAssembler.toModel(entity.getJob()))
                .departament(departamentAssembler.toModel(entity.getDepartament()))
                .build();
    }
    
}
