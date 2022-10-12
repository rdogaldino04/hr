package com.rgv04.hr.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDTO {

    private String id;

    private String title;

    private Long minSalary;

    private Long maxSalary;

}
