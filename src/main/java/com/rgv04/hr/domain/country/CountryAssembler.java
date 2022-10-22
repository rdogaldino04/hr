package com.rgv04.hr.domain.country;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;
import com.rgv04.hr.domain.region.assembler.RegionAssembler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CountryAssembler implements Assembler<Country, CountryModel> {

	@Autowired
	private RegionAssembler regionAssembler;

	@Override
	public List<CountryModel> toListModel(List<Country> listEntity) {
		List<CountryModel> countryDtoList = listEntity.stream().map(country -> {
			return CountryModel.builder()
					.id(country.getId())
					.name(country.getName())
					.region(regionAssembler.toModel(country.getRegion()))
					.build();
		}).collect(Collectors.toList());
		return countryDtoList;
	}

	@Override
	public CountryModel toModel(Country country) {
		if (country == null) {
			return new CountryModel();
		}
		return CountryModel.builder()
				.id(country.getId())
				.name(country.getName())
				.region(regionAssembler.toModel(country.getRegion()))
				.build();
	}

}
