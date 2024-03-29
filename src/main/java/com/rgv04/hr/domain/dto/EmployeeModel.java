package com.rgv04.hr.domain.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "employees")
public class EmployeeModel extends RepresentationModel<EmployeeModel> {

	@EqualsAndHashCode.Include
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private OffsetDateTime hireDate;

	private JobModel job;

	private BigDecimal salary;

	private BigDecimal commissionPct;

	private EmployeeManagerModel employeeManager;

	private DepartamentModel departament;

}
