package com.rgv04.hr.controller.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.controller.model.EmployeeModel;
import com.rgv04.hr.model.Employee;
import com.rgv04.hr.model.dto.EmployeeManagerDTO;

@Component
public class EmployeeAssembler implements Assembler<Employee, EmployeeModel> {

	@Autowired
	private JobAssembler jobAssembler;

	@Autowired
	private DepartamentAssembler departamentAssembler;

	@Override
	public List<EmployeeModel> toListDto(List<Employee> entities) {
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
						.job(this.jobAssembler.toDto(entity.getJob()))
						.salary(entity.getSalary())
						.employeeManager(createEmployeeManager(entity.getEmployeeManager()))
						.commissionPct(entity.getCommissionPct())
						.departament(this.departamentAssembler.toDto(entity.getDepartament()))
						.build();
			}).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	@Override
	public EmployeeModel toDto(Employee entity) {
		return EmployeeModel
				.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber())
				.hireDate(entity.getHireDate())
				.job(this.jobAssembler.toDto(entity.getJob()))
				.salary(entity.getSalary())
				.employeeManager(createEmployeeManager(entity.getEmployeeManager()))
				.commissionPct(entity.getCommissionPct())
				.departament(this.departamentAssembler.toDto(entity.getDepartament()))
				.build();
	}

	private EmployeeManagerDTO createEmployeeManager(Employee entity) {
		if (entity == null) {
			return EmployeeManagerDTO.builder()
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
		return EmployeeManagerDTO.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber())
				.hireDate(entity.getHireDate())
				.job(this.jobAssembler.toDto(entity.getJob()))
				.salary(entity.getSalary())
				.commissionPct(entity.getCommissionPct())
				.departament(departamentAssembler.toDto(entity.getDepartament()))
				.build();
	}

}
