package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.api.controller.DepartamentController;
import com.rgv04.hr.domain.dto.DepartamentModel;
import com.rgv04.hr.domain.model.Departament;

@Component
public class DepartamentAssembler extends RepresentationModelAssemblerSupport<Departament, DepartamentModel> {

    @Autowired
    private ModelMapper modelMapper;

    public DepartamentAssembler() {
        super(DepartamentController.class, DepartamentModel.class);
    }

    @Override
    public DepartamentModel toModel(Departament entity) {
        DepartamentModel model = createModelWithId(entity.getId(), entity);
        modelMapper.map(entity, model);
        return model;
    }

}
