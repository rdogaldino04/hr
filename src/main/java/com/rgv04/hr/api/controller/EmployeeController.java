package com.rgv04.hr.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.dto.EmployeeFilter;
import com.rgv04.hr.domain.dto.EmployeeModel;
import com.rgv04.hr.domain.dto.EmployeeOnlyFirstNameAndHireDate;
import com.rgv04.hr.domain.dto.EmployeeSumary;
import com.rgv04.hr.domain.repository.EmployeeRepository;
import com.rgv04.hr.domain.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	public ResponseEntity<CollectionModel<EmployeeModel>> findAll() {
		return ResponseEntity.ok(employeeService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeModel> findById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}

	@GetMapping("joined")
	public ResponseEntity<List<EmployeeOnlyFirstNameAndHireDate>> listByJoinedYear(@Valid EmployeeFilter filter) {		
		return ResponseEntity.ok(employeeRepository.listByJoinedYear(filter));
	}

	@GetMapping("{id}/summary")
	public ResponseEntity<EmployeeSumary> listByIdSummary(@PathVariable Long id) {		
		return ResponseEntity.ok(employeeRepository.listByIdSummary(id));
	}

}
