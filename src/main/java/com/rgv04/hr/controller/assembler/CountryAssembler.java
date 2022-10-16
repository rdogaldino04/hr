package com.rgv04.hr.controller.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.controller.model.CountryModel;
import com.rgv04.hr.model.Country;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CountryAssembler implements Assembler<Country, CountryModel> {

	@Override
	public List<CountryModel> toListDto(List<Country> listEntity) {
		List<CountryModel> countryDtoList = new ArrayList<>();
		listEntity.forEach(country -> {
			CountryModel countryDto = new CountryModel();
			countryDto.setId(country.getId());
			countryDto.setName(country.getName());
			countryDtoList.add(countryDto);
		});
		return countryDtoList;
	}

	@Override
	public CountryModel toDto(Country country) {
		CountryModel countryDTO = new CountryModel();
		countryDTO.setId(country.getId());
		countryDTO.setName(country.getName());
		return countryDTO;
	}

}
