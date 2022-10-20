package com.rgv04.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rgv04.hr.infra.spec.CountrySpecs;
import com.rgv04.hr.model.Country;
import com.rgv04.hr.model.Region;
import com.rgv04.hr.model.filter.CountryFilter;
import com.rgv04.hr.repository.CountryRepository;
import com.rgv04.hr.service.exception.CountryNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CountryService {
	
	private static final String THERE_IS_NO_REGISTRATION_OF_COUNTRY_WITH_CODE = "There is no registration of country with code %s";

	private final CountryRepository countryRepository;

	public List<Country> findByRegion(Long regionId) throws IllegalArgumentException {
		Region region = new Region();
		region.setId(regionId);
		return this.countryRepository.findByRegion(region);
	}

	public Country findById(String id) {
		return countryRepository
		  .findById(id)
		  .orElseThrow(() -> new CountryNotFoundException(String.format(THERE_IS_NO_REGISTRATION_OF_COUNTRY_WITH_CODE, id)));
	}

    public List<Country> findAll(CountryFilter countryFilter) {		
        return this.countryRepository.findAll(CountrySpecs.getSpecs(countryFilter));
    }

}
