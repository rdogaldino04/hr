package com.rgv04.hr.domain.repository;

import java.util.List;

import com.rgv04.hr.domain.dto.RegionFilter;
import com.rgv04.hr.domain.model.Region;

public interface RegionRepositoryQueries {

	List<Region> listByFilter(RegionFilter filter);
	
}
