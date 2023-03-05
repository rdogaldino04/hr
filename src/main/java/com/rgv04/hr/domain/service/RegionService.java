package com.rgv04.hr.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rgv04.hr.domain.assembler.RegionAssembler;
import com.rgv04.hr.domain.assembler.RegionWithCountryAssembler;
import com.rgv04.hr.domain.dto.RegionFilter;
import com.rgv04.hr.domain.dto.RegionModel;
import com.rgv04.hr.domain.dto.RegionWithCountryModel;
import com.rgv04.hr.domain.exception.BusinessException;
import com.rgv04.hr.domain.exception.RegionNotFoundException;
import com.rgv04.hr.domain.model.Region;
import com.rgv04.hr.domain.repository.RegionRepository;

@Service
@Transactional
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private RegionAssembler regionAssembler;

	@Autowired
	private RegionWithCountryAssembler regionWithCountryAssembler;

	public RegionModel save(Region region) {
		region.setId(null);
		return this.regionAssembler.toModel(this.regionRepository.save(region));
	}

	public CollectionModel<RegionModel> listByFilter(RegionFilter filter) {
		return this.regionAssembler.toCollectionModel(this.regionRepository.listByFilter(filter));
	}

	public RegionModel findById(Long id) {
		return this.regionAssembler.toModel(this.regionRepository
				.findById(id)
				.orElseThrow(() -> new RegionNotFoundException(id)));
	}

	public RegionWithCountryModel countriesByRegionId(Long regionId) {
		return this.regionWithCountryAssembler.toModel(this.regionRepository
				.countriesByRegionId(regionId)
				.orElseThrow(() -> new BusinessException("resource not found")));
	}

}
