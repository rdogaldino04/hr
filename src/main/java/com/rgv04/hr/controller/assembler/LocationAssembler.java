package com.rgv04.hr.controller.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.model.Location;
import com.rgv04.hr.model.dto.LocationDTO;

@Component
public class LocationAssembler implements Assembler<Location, LocationDTO> {

	@Autowired
	private CountryAssembler countryAssembler;

	@Override
	public List<LocationDTO> toListDto(List<Location> entities) {
		if (entities != null && entities.size() > 0) {
			List<LocationDTO> locationDTOs = entities.stream().map(e -> {
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setId(e.getId());
				locationDTO.setCity(e.getCity());
				locationDTO.setPostalCode(e.getPostalCode());
				locationDTO.setStateProvince(e.getStateProvince());
				locationDTO.setStreetAddress(e.getStreetAddress());
				locationDTO.setCountry(this.countryAssembler.toDto(e.getCountry()));
				return locationDTO;
			}).collect(Collectors.toList());
			return locationDTOs;
		}
		return new ArrayList<>();
	}

	@Override
	public LocationDTO toDto(Location entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
