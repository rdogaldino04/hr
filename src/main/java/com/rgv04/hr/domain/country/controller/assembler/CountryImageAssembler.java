package com.rgv04.hr.domain.country.controller.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.controller.CountryImageController;
import com.rgv04.hr.domain.country.controller.model.CountryImageModel;
import com.rgv04.hr.domain.country.entity.CountryImage;

@Component
public class CountryImageAssembler extends RepresentationModelAssemblerSupport<CountryImage, CountryImageModel> {

    @Autowired
	private ModelMapper modelMapper;
    
    public CountryImageAssembler() {
        super(CountryImageController.class, CountryImageModel.class);
    }

    @Override
    public CountryImageModel toModel(CountryImage entity) {
        CountryImageModel model = modelMapper.map(entity, CountryImageModel.class);
		return model;
    }
    
}
