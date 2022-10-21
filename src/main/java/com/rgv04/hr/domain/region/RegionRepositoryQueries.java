package com.rgv04.hr.domain.region;

import java.util.List;

public interface RegionRepositoryQueries {

	List<Region> listByFilter(RegionFilter filter);
	
}
