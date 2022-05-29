package com.rgv04.hr.repository;

import java.util.List;

import com.rgv04.hr.model.Location;
import com.rgv04.hr.model.filter.LocationFilter;

public interface LocationRepositoryQueries {

	List<Location> findByFilter(LocationFilter filter);

}
