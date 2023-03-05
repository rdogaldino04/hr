package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.domain.dto.CountryImageModel;
import com.rgv04.hr.domain.model.CountryImage;

@Component
public class CountryImageDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public CountryImage toDomainObject(CountryImageModel countryImageModel) {
		return modelMapper.map(countryImageModel, CountryImage.class);
	}

}
