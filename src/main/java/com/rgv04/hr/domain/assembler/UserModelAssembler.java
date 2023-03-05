package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.api.controller.UserController;
import com.rgv04.hr.domain.dto.UserModel;
import com.rgv04.hr.domain.model.User;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, UserModel> {

    @Autowired
	private ModelMapper modelMapper;
    
    public UserModelAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public CollectionModel<UserModel> toCollectionModel(Iterable<? extends User> entities) {        
        return super.toCollectionModel(entities);
    }

    @Override
    public UserModel toModel(User entity) {
        UserModel model = super.createModelWithId(entity.getId(), entity);
        modelMapper.map(entity, model);
        return model;
    }
    
}
