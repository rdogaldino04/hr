package com.rgv04.hr.controller.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.controller.model.RegionModel;
import com.rgv04.hr.model.Region;

@Component
public class RegionAssembler implements Assembler<Region, RegionModel> {

	@Override
	public ArrayList<RegionModel> toListModel(List<Region> listEntity) {
		ArrayList<RegionModel> list = new ArrayList<>();
		listEntity.forEach(r -> {
			RegionModel regionDTO = new RegionModel();
			regionDTO.setId(r.getId());
			regionDTO.setName(r.getName());
			list.add(regionDTO);
		});
		return list;
	}

	@Override
	public RegionModel toModel(Region region) {
		RegionModel regionDTO = new RegionModel();
		regionDTO.setId(region.getId());
		regionDTO.setName(region.getName());
		return regionDTO;
	}

}
