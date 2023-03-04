package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.api.controller.LocationController;
import com.rgv04.hr.domain.dto.LocationModel;
import com.rgv04.hr.domain.model.Location;

@Component
public class LocationAssembler extends RepresentationModelAssemblerSupport<Location, LocationModel> {

	@Autowired
	private ModelMapper modelMapper;

	public LocationAssembler() {
		super(LocationController.class, LocationModel.class);
	}

	@Override
	public LocationModel toModel(Location entity) {
		LocationModel model = createModelWithId(entity.getId(), entity);
		modelMapper.map(entity, model);
		return model;
	}

}
