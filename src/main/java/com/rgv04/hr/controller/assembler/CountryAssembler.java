package com.rgv04.hr.controller.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.model.Country;
import com.rgv04.hr.model.dto.CountryDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CountryAssembler implements Assembler<Country, CountryDTO> {

	private final RegionAssembler regionAssembler;

	@Override
	public List<CountryDTO> toListDto(List<Country> listEntity) {
		List<CountryDTO> countryDtoList = new ArrayList<>();
		listEntity.forEach(country -> {
			CountryDTO countryDto = new CountryDTO();
			countryDto.setId(country.getId());
			countryDto.setName(country.getName());
			countryDto.setRegion(this.regionAssembler.toDto(country.getRegion()));
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
