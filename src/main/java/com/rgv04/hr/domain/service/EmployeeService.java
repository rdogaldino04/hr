package com.rgv04.hr.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.assembler.EmployeeAssembler;
import com.rgv04.hr.domain.dto.EmployeeModel;
import com.rgv04.hr.domain.model.Employee;
import com.rgv04.hr.domain.repository.EmployeeRepository;
import com.rgv04.hr.exception.BusinessException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeAssembler employeeAssembler;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public EmployeeModel findById(Long id) {
		return this.employeeAssembler.toModel(this.employeeRepository.findById(id)
			.orElseThrow(() -> new BusinessException("Resource not found")));
	}

}
