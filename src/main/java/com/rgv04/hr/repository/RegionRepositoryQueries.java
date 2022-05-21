package com.rgv04.hr.repository;

import java.util.List;

import com.rgv04.hr.model.Region;
import com.rgv04.hr.model.filter.RegionFilter;

public interface RegionRepositoryQueries {

	List<Region> listByFilter(RegionFilter filter);
	
	Region byId(Long id);

}
