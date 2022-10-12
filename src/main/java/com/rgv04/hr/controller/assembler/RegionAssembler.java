package com.rgv04.hr.controller.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.model.Region;
import com.rgv04.hr.model.dto.RegionDTO;

@Component
public class RegionAssembler implements Assembler<Region, RegionDTO> {

	@Override
	public ArrayList<RegionDTO> toListDto(List<Region> listEntity) {
		ArrayList<RegionDTO> list = new ArrayList<>();
		listEntity.forEach(r -> {
			RegionDTO regionDTO = new RegionDTO();
			regionDTO.setId(r.getId());
			regionDTO.setName(r.getName());
			list.add(regionDTO);
		});
		return list;
	}

	@Override
	public RegionDTO toDto(Region region) {
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setId(region.getId());
		regionDTO.setName(region.getName());
		return regionDTO;
	}

}
