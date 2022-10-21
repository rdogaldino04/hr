package com.rgv04.hr.domain.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;
import com.rgv04.hr.domain.departament.DepartamentAssembler;
import com.rgv04.hr.domain.job.controller.assembler.JobAssembler;

@Component
public class EmployeeAssembler implements Assembler<Employee, EmployeeModel> {

	@Autowired
	private JobAssembler jobAssembler;

	@Autowired
	private DepartamentAssembler departamentAssembler;

	@Override
	public List<EmployeeModel> toListModel(List<Employee> entities) {
		if (entities != null && entities.size() > 0) {
			return entities.stream().map(entity -> {
				return EmployeeModel
						.builder()
						.id(entity.getId())
						.firstName(entity.getFirstName())
						.lastName(entity.getLastName())
						.email(entity.getEmail())
						.phoneNumber(entity.getPhoneNumber())
						.hireDate(entity.getHireDate())
						.job(this.jobAssembler.toModel(entity.getJob()))
						.salary(entity.getSalary())
						.employeeManager(createEmployeeManager(entity.getEmployeeManager()))
						.commissionPct(entity.getCommissionPct())
						.departament(this.departamentAssembler.toModel(entity.getDepartament()))
						.build();
			}).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	@Override
	public EmployeeModel toModel(Employee entity) {
		return EmployeeModel
				.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber())
				.hireDate(entity.getHireDate())
				.job(this.jobAssembler.toModel(entity.getJob()))
				.salary(entity.getSalary())
				.employeeManager(createEmployeeManager(entity.getEmployeeManager()))
				.commissionPct(entity.getCommissionPct())
				.departament(this.departamentAssembler.toModel(entity.getDepartament()))
				.build();
	}

	private EmployeeManagerModel createEmployeeManager(Employee entity) {
		if (entity == null) {
			return EmployeeManagerModel.builder()
					.id(null)
					.firstName(null)
					.lastName(null)
					.email(null)
					.phoneNumber(null)
					.hireDate(null)
					.job(null)
					.salary(null)
					.commissionPct(null)
					.departament(null)
					.build();
		}
		return EmployeeManagerModel.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber())
				.hireDate(entity.getHireDate())
				.job(this.jobAssembler.toModel(entity.getJob()))
				.salary(entity.getSalary())
				.commissionPct(entity.getCommissionPct())
				.departament(departamentAssembler.toModel(entity.getDepartament()))
				.build();
	}

}
