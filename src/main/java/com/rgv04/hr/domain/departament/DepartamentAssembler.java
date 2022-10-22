package com.rgv04.hr.domain.departament;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class DepartamentAssembler extends RepresentationModelAssemblerSupport<Departament, DepartamentModel> {

    @Autowired
    private ModelMapper modelMapper;

    public DepartamentAssembler() {
        super(DepartamentController.class, DepartamentModel.class);
    }

    @Override
    public CollectionModel<DepartamentModel> toCollectionModel(Iterable<? extends Departament> entities) {
        return super.toCollectionModel(entities);
    }

    @Override
    public DepartamentModel toModel(Departament entity) {
        DepartamentModel model = createModelWithId(entity.getId(), entity);
        modelMapper.map(entity, model);
        return model;
    }

}
