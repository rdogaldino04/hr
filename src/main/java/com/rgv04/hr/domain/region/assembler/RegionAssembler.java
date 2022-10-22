package com.rgv04.hr.domain.region.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.domain.region.Region;
import com.rgv04.hr.domain.region.RegionController;
import com.rgv04.hr.domain.region.assembler.model.RegionModel;

@Component
public class RegionAssembler extends RepresentationModelAssemblerSupport<Region, RegionModel> {

	public RegionAssembler() {
		super(RegionController.class, RegionModel.class);
	}

	@Override
	public CollectionModel<RegionModel> toCollectionModel(Iterable<? extends Region> entities) {
		CollectionModel<RegionModel> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}

	@Override
	public RegionModel toModel(Region entity) {
		if (entity == null) {
			entity = new Region();
		}
		return RegionModel.builder()
				.id(entity.getId())
				.name(entity.getName())
				.build();
	}

}
