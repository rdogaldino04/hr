package com.rgv04.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.model.Employee;
import com.rgv04.hr.model.filter.EmployeeFilter;
import com.rgv04.hr.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findByFilter(EmployeeFilter filter) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}
