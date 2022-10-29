package com.rgv04.hr.domain.country;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.domain.country.controller.CountryController;

@Component
public class CountryAssembler extends RepresentationModelAssemblerSupport<Country, CountryModel> {

	@Autowired
	private ModelMapper modelMapper;

	public CountryAssembler() {
		super(CountryController.class, CountryModel.class);
	}

	@Override
	public CollectionModel<CountryModel> toCollectionModel(Iterable<? extends Country> entities) {
		CollectionModel<CountryModel> collectionModel = super.toCollectionModel(entities);
		return collectionModel;
	}

	@Override
	public CountryModel toModel(Country entity) {
		CountryModel countryModel = super.createModelWithId(entity.getId(), entity);
		modelMapper.map(entity, countryModel);
		return countryModel;
	}

}
