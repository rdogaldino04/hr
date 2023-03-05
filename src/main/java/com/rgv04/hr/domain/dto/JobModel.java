package com.rgv04.hr.domain.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

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
@Relation(collectionRelation = "jobs")
public class JobModel extends RepresentationModel<JobModel> {

    private String id;

    private String title;

    private Long minSalary;

    private Long maxSalary;

}
