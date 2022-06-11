package com.rgv04.hr.controller.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rgv04.hr.model.Employee;
import com.rgv04.hr.model.dto.EmployeeDTO;

@Component
public class EmployeeAssembler implements Assembler<Employee, EmployeeDTO> {

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
		// TODO Auto-generated method stub
		return null;
	}

}
