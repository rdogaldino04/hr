package com.rgv04.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.model.Region;
import com.rgv04.hr.model.filter.RegionFilter;
import com.rgv04.hr.repository.RegionRepository;
import com.rgv04.hr.service.exception.RegionNotFindException;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;

	public List<Region> listByFilter(RegionFilter filter) {
		return this.regionRepository.listByFilter(filter);
	}

	public Region byId(Long id) {
		Region region = this.regionRepository.byId(id);
		if (region == null) {
			throw new RegionNotFindException(id);
		}
		return region;
	}

	public Region byCountry(RegionFilter filter) {
		List<Region> listByFilter = this.regionRepository.listByFilter(filter);
		if (listByFilter != null && listByFilter.size() > 0) {
			return listByFilter.get(0);
		}
		throw new RegionNotFindException(filter.getRegionId(), filter.getCountryId());

	}

}
