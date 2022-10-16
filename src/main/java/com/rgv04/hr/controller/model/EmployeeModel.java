package com.rgv04.hr.controller.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.rgv04.hr.model.dto.DepartamentDTO;
import com.rgv04.hr.model.dto.EmployeeManagerDTO;
import com.rgv04.hr.model.dto.JobDTO;

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

	private JobDTO job;

	private BigDecimal salary;

	private BigDecimal commissionPct;

	private EmployeeManagerDTO employeeManager;

	private DepartamentDTO departament;

}
