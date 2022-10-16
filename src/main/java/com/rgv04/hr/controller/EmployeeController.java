package com.rgv04.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.controller.assembler.EmployeeAssembler;
import com.rgv04.hr.controller.model.EmployeeModel;
import com.rgv04.hr.model.Employee;
import com.rgv04.hr.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeAssembler employeeAssembler;

	@GetMapping
	public ResponseEntity<List<EmployeeModel>> findAll() {
		List<Employee> employees = employeeService.findAll();
		List<EmployeeModel> employeeDTOs = employeeAssembler.toListDto(employees);
		return ResponseEntity.ok(employeeDTOs);
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeModel> findById(@PathVariable Long id) {
		Employee employee = employeeService.findById(id);
		EmployeeModel employeeDTO = employeeAssembler.toDto(employee);
		return ResponseEntity.ok(employeeDTO);
	}

}
