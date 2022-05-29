package com.rgv04.hr.controller.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.model.Region;
import com.rgv04.hr.model.dto.RegionDTO;

@Component
public class RegionAssembler implements Assembler<Region, RegionDTO> {

	@Autowired
	private CountryAssembler countryAssembler;

	@Override
	public ArrayList<RegionDTO> toListDto(List<Region> listEntity) {
		ArrayList<RegionDTO> list = new ArrayList<>();
		listEntity.forEach(r -> {
			RegionDTO regionDTO = new RegionDTO();
			regionDTO.setId(r.getId());
			regionDTO.setName(r.getName());
			regionDTO.setCountries(countryAssembler.toListDto(r.getCountries()));
			list.add(regionDTO);
		});
		return list;
	}

	@Override
	public RegionDTO toDto(Region region) {
		if (region != null) {
			RegionDTO regionDTO = new RegionDTO();
			regionDTO.setId(region.getId());
			regionDTO.setName(region.getName());
			regionDTO.setCountries(countryAssembler.toListDto(region.getCountries()));
			return regionDTO;
		}
		throw new IllegalArgumentException("objeto region está null");
	}

}
