package com.rgv04.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.controller.assembler.EmployeeAssembler;
import com.rgv04.hr.model.Employee;
import com.rgv04.hr.model.dto.EmployeeDTO;
import com.rgv04.hr.model.filter.EmployeeFilter;
import com.rgv04.hr.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeAssembler employeeAssembler;

	@GetMapping
	public List<EmployeeDTO> findByFilter(EmployeeFilter filter) {
		List<Employee> findByFilter = employeeService.findByFilter(filter);
		List<EmployeeDTO> listDto = employeeAssembler.toListDto(findByFilter);
		return listDto;
	}

}
