package com.rgv04.hr.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.service.exception.BusinessException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee findById(Long id) {
		return this.employeeRepository.findById(id)
			.orElseThrow(() -> new BusinessException("Resource not found"));
	}

}
