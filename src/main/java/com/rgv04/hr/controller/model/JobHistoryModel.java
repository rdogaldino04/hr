package com.rgv04.hr.controller.model;

import java.time.OffsetDateTime;

import com.rgv04.hr.job.controller.model.JobModel;

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
