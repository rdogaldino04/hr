package com.rgv04.hr.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.assembler.LocationAssembler;
import com.rgv04.hr.domain.dto.LocationFilter;
import com.rgv04.hr.domain.dto.LocationModel;
import com.rgv04.hr.domain.exception.BusinessException;
import com.rgv04.hr.domain.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private LocationAssembler locationAssembler;

	public CollectionModel<LocationModel> listByFilter(LocationFilter filter) {
		return locationAssembler.toCollectionModel(locationRepository.listByFilter(filter));
	}

	public LocationModel findById(Long id) {
		return locationAssembler.toModel(locationRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Entity not found")));
	}

}
