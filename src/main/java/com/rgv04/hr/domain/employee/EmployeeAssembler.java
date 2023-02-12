package com.rgv04.hr.domain.employee;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.controller.EmployeeController;

@Component
public class EmployeeAssembler extends RepresentationModelAssemblerSupport<Employee, EmployeeModel> {

	@Autowired
	private EmployeeManagerModelAssembler employeeManagerModelAssembler;

	@Autowired
	private ModelMapper modelMapper;

	public EmployeeAssembler() {
		super(EmployeeController.class, EmployeeModel.class);
	}

	@Override
	public CollectionModel<EmployeeModel> toCollectionModel(Iterable<? extends Employee> entities) {
		return super.toCollectionModel(entities);
	}

	@Override
	public EmployeeModel toModel(Employee entity) {
		EmployeeManagerModel employeeManagerModel = employeeManagerModelAssembler.toModel(entity.getEmployeeManager());
		EmployeeModel model = createModelWithId(entity.getId(), entity);
		model.setEmployeeManager(employeeManagerModel);
		modelMapper.map(entity, model);
		return model;
	}

}
