package com.rgv04.hr.domain.location;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.controller.LocationController;

@Component
public class LocationAssembler extends RepresentationModelAssemblerSupport<Location, LocationModel> {

	@Autowired
	private ModelMapper modelMapper;

	public LocationAssembler() {
		super(LocationController.class, LocationModel.class);
	}

	@Override
	public CollectionModel<LocationModel> toCollectionModel(Iterable<? extends Location> entities) {
		CollectionModel<LocationModel> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}

	@Override
	public LocationModel toModel(Location entity) {
		LocationModel model = createModelWithId(entity.getId(), entity);
		modelMapper.map(entity, model);
		return model;
	}

}
