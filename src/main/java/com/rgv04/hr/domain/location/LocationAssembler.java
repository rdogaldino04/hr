package com.rgv04.hr.domain.location;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;
import com.rgv04.hr.domain.country.CountryAssembler;

@Component
public class LocationAssembler implements Assembler<Location, LocationModel> {

	@Autowired
	private CountryAssembler countryAssembler;

	@Override
	public List<LocationModel> toListModel(List<Location> entities) {
		if (entities != null && entities.size() > 0) {
			List<LocationModel> locationDTOs = entities.stream().map(e -> {
				LocationModel locationDTO = new LocationModel();
				locationDTO.setId(e.getId());
				locationDTO.setCity(e.getCity());
				locationDTO.setPostalCode(e.getPostalCode());
				locationDTO.setStateProvince(e.getStateProvince());
				locationDTO.setStreetAddress(e.getStreetAddress());
				locationDTO.setCountry(this.countryAssembler.toModel(e.getCountry()));
				return locationDTO;
			}).collect(Collectors.toList());
			return locationDTOs;
		}
		return new ArrayList<>();
	}

	@Override
	public LocationModel toModel(Location entity) {
		return LocationModel.builder()
				.id(entity.getId())
				.city(entity.getCity())
				.postalCode(entity.getPostalCode())
				.stateProvince(entity.getStateProvince())
				.streetAddress(entity.getStreetAddress())
				.country(this.countryAssembler.toModel(entity.getCountry()))
				.build();
	}

}