package com.rgv04.hr.controller.model;

import java.time.OffsetDateTime;

import com.rgv04.hr.model.dto.DepartamentDTO;
import com.rgv04.hr.model.dto.JobDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobHistoryModel {

    private Long employeeId;

    private OffsetDateTime startDate;

    private OffsetDateTime endDate;

    private JobDTO job;

    private DepartamentDTO departament;

}
