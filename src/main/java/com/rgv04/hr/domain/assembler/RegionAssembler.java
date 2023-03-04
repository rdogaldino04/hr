package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.api.controller.RegionController;
import com.rgv04.hr.domain.dto.RegionModel;
import com.rgv04.hr.domain.model.Region;

@Component
public class RegionAssembler extends RepresentationModelAssemblerSupport<Region, RegionModel> {

	@Autowired
	private ModelMapper modelMapper;

	public RegionAssembler() {
		super(RegionController.class, RegionModel.class);
	}

	@Override
	public RegionModel toModel(Region entity) {
		RegionModel regionModel = createModelWithId(entity.getId(), entity);
		modelMapper.map(entity, regionModel);
		return regionModel;
	}

}
