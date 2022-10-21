package com.rgv04.hr.domain.job.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobModel {

    private String id;

    private String title;

    private Long minSalary;

    private Long maxSalary;

}
