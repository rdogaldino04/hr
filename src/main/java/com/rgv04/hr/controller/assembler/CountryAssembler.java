package com.rgv04.hr.controller.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.controller.model.CountryModel;
import com.rgv04.hr.model.Country;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CountryAssembler implements Assembler<Country, CountryModel> {

	@Autowired
	private RegionAssembler regionAssembler;

	@Override
	public List<CountryModel> toListDto(List<Country> listEntity) {
		List<CountryModel> countryDtoList = listEntity.stream().map(country -> {
			return CountryModel.builder()
					.id(country.getId())
					.name(country.getName())
					.region(regionAssembler.toDto(country.getRegion()))
					.build();
		}).collect(Collectors.toList());
		return countryDtoList;
	}

	@Override
	public CountryModel toDto(Country country) {
		return CountryModel.builder()
				.id(country.getId())
				.name(country.getName())
				.region(regionAssembler.toDto(country.getRegion()))
				.build();
	}

}
