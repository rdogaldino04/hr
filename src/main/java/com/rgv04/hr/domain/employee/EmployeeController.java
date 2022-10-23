package com.rgv04.hr.domain.employee;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeAssembler employeeAssembler;

	@GetMapping
	public ResponseEntity<CollectionModel<EmployeeModel>> findAll() {
		List<Employee> employees = employeeService.findAll();
		return ResponseEntity.ok(employeeAssembler.toCollectionModel(employees));
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeModel> findById(@PathVariable Long id) {
		Employee employee = employeeService.findById(id);
		EmployeeModel employeeModel = employeeAssembler.toModel(employee);
		return ResponseEntity.ok(employeeModel);
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
