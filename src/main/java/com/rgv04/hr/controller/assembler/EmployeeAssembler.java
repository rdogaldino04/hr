package com.rgv04.hr.controller.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.model.Employee;
import com.rgv04.hr.model.dto.EmployeeDTO;
import com.rgv04.hr.model.dto.EmployeeManagerDTO;

@Component
public class EmployeeAssembler implements Assembler<Employee, EmployeeDTO> {

	@Autowired
	private JobAssembler jobAssembler;

	@Autowired
	private DepartamentAssembler departamentAssembler;

	@Override
	public List<EmployeeDTO> toListDto(List<Employee> entities) {
		if (entities != null && entities.size() > 0) {
			return entities.stream().map(e -> {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setId(e.getId());
				employeeDTO.setFirstName(e.getFirstName());
				employeeDTO.setLastName(e.getLastName());
				employeeDTO.setEmail(e.getEmail());
				employeeDTO.setPhoneNumber(e.getPhoneNumber());
				employeeDTO.setHireDate(e.getHireDate());
				employeeDTO.setSalary(e.getSalary());
				employeeDTO.setCommissionPct(e.getCommissionPct());

				return employeeDTO;
			}).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	@Override
	public EmployeeDTO toDto(Employee entity) {
		EmployeeDTO employeeDTO = EmployeeDTO
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
		return employeeDTO;
	}

	private EmployeeManagerDTO createEmployeeManager(Employee entity) {
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
