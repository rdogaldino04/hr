package com.rgv04.hr.domain.employee;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rgv04.hr.domain.departament.Departament;
import com.rgv04.hr.domain.job.model.Job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private OffsetDateTime hireDate;

	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "job_id")
	private Job job;

	private BigDecimal salary;

	private BigDecimal commissionPct;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee employeeManager;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Departament departament;

}
