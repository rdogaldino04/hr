package com.rgv04.hr.domain.dto;

import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class JobHistoryIdModel extends RepresentationModel<JobHistoryIdModel>  {

    private Long employeeId;

    private OffsetDateTime startDate;

}
