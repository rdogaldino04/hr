package com.rgv04.hr.domain.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.assembler.EmployeeAssembler;
import com.rgv04.hr.domain.dto.EmployeeFilter;
import com.rgv04.hr.domain.dto.EmployeeModel;
import com.rgv04.hr.domain.dto.EmployeeSumary;
import com.rgv04.hr.domain.repository.EmployeeRepository;
import com.rgv04.hr.exception.BusinessException;
import com.rgv04.hr.domain.dto.EmployeeOnlyFirstNameAndHireDate;
import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeAssembler employeeAssembler;

	public CollectionModel<EmployeeModel> findAll() {
		return this.employeeAssembler.toCollectionModel(employeeRepository.findAll());
	}

	public EmployeeModel findById(Long id) {
		return this.employeeAssembler.toModel(this.employeeRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Resource not found")));
	}

	public List<EmployeeOnlyFirstNameAndHireDate> listByJoinedYear(@Valid EmployeeFilter filter) {
		return employeeRepository.listByJoinedYear(filter);
	}

	public EmployeeSumary listByIdSummary(Long id) {
		return employeeRepository.listByIdSummary(id);
	}

}
