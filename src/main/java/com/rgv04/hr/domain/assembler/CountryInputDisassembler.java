package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.domain.dto.CountryModel;
import com.rgv04.hr.domain.model.Country;

@Component
public class CountryInputDisassembler {

    @Autowired
	private ModelMapper modelMapper;

    public Country toDomainObject(CountryModel countryModel) {
		return modelMapper.map(countryModel, Country.class);
	}
    
}
