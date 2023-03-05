package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.api.controller.CountryImageController;
import com.rgv04.hr.domain.dto.CountryImageModel;
import com.rgv04.hr.domain.model.CountryImage;

@Component
public class CountryImageAssembler extends RepresentationModelAssemblerSupport<CountryImage, CountryImageModel> {

    @Autowired
	private ModelMapper modelMapper;
    
    public CountryImageAssembler() {
        super(CountryImageController.class, CountryImageModel.class);
    }

    @Override
    public CountryImageModel toModel(CountryImage entity) {
        return modelMapper.map(entity, CountryImageModel.class);
    }
    
}
