package com.rgv04.hr.controller.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.model.Country;
import com.rgv04.hr.model.dto.CountryDTO;

@Component
public class CountryAssembler implements Assembler<Country, CountryDTO> {

	@Override
	public List<CountryDTO> toListDto(List<Country> listEntity) {
		List<CountryDTO> countryDtoList = new ArrayList<>();
		listEntity.forEach(country -> {
			CountryDTO countryDto = new CountryDTO();
			countryDto.setId(country.getId());
			countryDto.setName(country.getName());
			countryDtoList.add(countryDto);
		});
		return countryDtoList;
	}

	@Override
	public CountryDTO toDto(Country country) {
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setId(country.getId());
		countryDTO.setName(country.getName());
		return countryDTO;
	}

}
