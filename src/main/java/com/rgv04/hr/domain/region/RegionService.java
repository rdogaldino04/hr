package com.rgv04.hr.domain.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rgv04.hr.domain.country.Country;
import com.rgv04.hr.domain.country.CountryService;

@Service
@Transactional
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private CountryService countryService;

	public Region save(Region region) {
		region.setId(null);
		return this.regionRepository.save(region);
	}

	public List<Region> listByFilter(RegionFilter filter) {
		return this.regionRepository.listByFilter(filter);
	}

	public Region findById(Long id) {
		return this.regionRepository
				.findById(id)
				.orElseThrow(() -> new RegionNotFoundException(id));
	}

	public List<Country> findByCountries(Long regionId) {
		return this.countryService.findByRegion(regionId);
	}

}
