package com.rgv04.hr.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employees", schema = "hr")
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private Long id;

	@Column(name = "FIRST_NAME")
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
