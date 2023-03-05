package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.api.controller.CountryController;
import com.rgv04.hr.domain.dto.CountryModel;
import com.rgv04.hr.domain.model.Country;

@Component
public class CountryAssembler extends RepresentationModelAssemblerSupport<Country, CountryModel> {

	@Autowired
	private ModelMapper modelMapper;

	public CountryAssembler() {
		super(CountryController.class, CountryModel.class);
	}

	@Override
	public CountryModel toModel(Country entity) {
		CountryModel countryModel = super.createModelWithId(entity.getId(), entity);
		modelMapper.map(entity, countryModel);
		return countryModel;
	}

}
