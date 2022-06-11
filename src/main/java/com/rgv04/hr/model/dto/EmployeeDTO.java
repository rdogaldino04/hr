package com.rgv04.hr.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeDTO {
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private LocalDate hireDate;

	// job_id

	private BigDecimal salary;

	private BigDecimal commissionPct;

	// MANAGER_ID

	// DEPARTMENT_ID
}
