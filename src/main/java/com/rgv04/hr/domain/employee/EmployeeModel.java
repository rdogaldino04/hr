package com.rgv04.hr.domain.employee;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.rgv04.hr.domain.departament.DepartamentModel;
import com.rgv04.hr.domain.job.controller.model.JobModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

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