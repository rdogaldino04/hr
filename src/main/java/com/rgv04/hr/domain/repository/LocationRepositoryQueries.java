package com.rgv04.hr.domain.repository;

import java.util.List;

import com.rgv04.hr.domain.dto.LocationFilter;
import com.rgv04.hr.domain.model.Location;

public interface LocationRepositoryQueries {

	List<Location> ListByFilter(LocationFilter filter);

}
