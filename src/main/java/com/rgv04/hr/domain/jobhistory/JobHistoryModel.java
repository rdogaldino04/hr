package com.rgv04.hr.domain.jobhistory;

import java.time.OffsetDateTime;

import com.rgv04.hr.domain.departament.DepartamentModel;
import com.rgv04.hr.domain.job.controller.model.JobModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobHistoryModel {

    private Long employeeId;

    private OffsetDateTime startDate;

    private OffsetDateTime endDate;

    private JobModel job;

    private DepartamentModel departament;

}
