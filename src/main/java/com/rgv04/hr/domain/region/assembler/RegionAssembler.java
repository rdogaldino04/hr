package com.rgv04.hr.domain.region.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;
import com.rgv04.hr.domain.region.Region;
import com.rgv04.hr.domain.region.assembler.model.RegionModel;

@Component
public class RegionAssembler implements Assembler<Region, RegionModel> {

	@Override
	public ArrayList<RegionModel> toListModel(List<Region> listEntity) {
		ArrayList<RegionModel> list = new ArrayList<>();
		listEntity.forEach(region -> {
			if (region != null) {
			  list.add(toModel(region));
			}
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
