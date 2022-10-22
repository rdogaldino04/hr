package com.rgv04.hr.domain.region;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;

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
	public RegionModel toModel(Region entity) {
		if (entity == null) {
			entity = new Region();
		}
		return RegionModel.builder()
				.id(entity.getId())
				.name(entity.getName())
				.build();
	}

}
