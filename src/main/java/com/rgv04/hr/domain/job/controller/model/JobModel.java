package com.rgv04.hr.domain.job.controller.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobModel extends RepresentationModel<JobModel> {

    private String id;

    private String title;

    private Long minSalary;

    private Long maxSalary;

}
