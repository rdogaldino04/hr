package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.api.controller.EmployeeController;
import com.rgv04.hr.domain.dto.EmployeeManagerModel;
import com.rgv04.hr.domain.model.Employee;

@Component
public class EmployeeManagerModelAssembler extends RepresentationModelAssemblerSupport<Employee, EmployeeManagerModel> {

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeManagerModelAssembler() {
        super(EmployeeController.class, EmployeeManagerModel.class);
    }

    @Override
    public EmployeeManagerModel toModel(Employee entity) {
        if (entity == null) {
            return null;
        }
        EmployeeManagerModel model = createModelWithId(entity.getId(), entity);
        modelMapper.map(entity, model);
        return model;
    }

}
