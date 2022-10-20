package com.rgv04.hr.job.model.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobFilter {

    private String jobId;

    private String title;
    
    private Long minSalary;
    
    private Long maxSalary;

    private Long minSalaryGreaterThan;
    
}
