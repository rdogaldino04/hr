package com.rgv04.hr.domain.jobhistory;

import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.rgv04.hr.domain.dto.DepartamentModel;
import com.rgv04.hr.domain.job.controller.model.JobModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "jobHistories")
public class JobHistoryModel extends RepresentationModel<JobHistoryModel> {

    private JobHistoryIdModel jobHistoryID;

    private OffsetDateTime endDate;

    private JobModel job;

    private DepartamentModel departament;

}
