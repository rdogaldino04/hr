package com.rgv04.hr.domain.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.exception.BusinessException;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public List<Location> ListByFilter(LocationFilter filter) {
		return locationRepository.ListByFilter(filter);
	}

	public Location findById(Long id) {
		return locationRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Entity not found"));
	}

}
