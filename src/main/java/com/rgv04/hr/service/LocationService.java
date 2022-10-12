package com.rgv04.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.model.Location;
import com.rgv04.hr.model.filter.LocationFilter;
import com.rgv04.hr.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public List<Location> findByFilter(LocationFilter filter) {
		return locationRepository.findByFilter(filter);
	}

}
