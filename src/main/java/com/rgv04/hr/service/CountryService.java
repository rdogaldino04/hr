package com.rgv04.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.model.Country;
import com.rgv04.hr.model.Region;
import com.rgv04.hr.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> findByRegion(Long regionId) throws IllegalArgumentException {
		Region region = new Region();
		region.setId(regionId);
		return this.countryRepository.findByRegion(region);
	}

}
