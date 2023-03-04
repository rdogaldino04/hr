package com.rgv04.hr.domain.service;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.assembler.CountryAssembler;
import com.rgv04.hr.domain.dto.CountryFilter;
import com.rgv04.hr.domain.dto.CountryModel;
import com.rgv04.hr.domain.exception.CountryNotFoundException;
import com.rgv04.hr.domain.model.Country;
import com.rgv04.hr.domain.region.Region;
import com.rgv04.hr.domain.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CountryService {
	
	private static final String THERE_IS_NO_REGISTRATION_OF_COUNTRY_WITH_CODE = "There is no registration of country with code %s";

	private final CountryRepository countryRepository;

	private final CountryAssembler countryAssembler;

	public List<Country> findByRegion(Long regionId) throws IllegalArgumentException {
		Region region = new Region();
		region.setId(regionId);
		return this.countryRepository.findByRegion(region);
	}

	public Country findById(String id) {
		return countryRepository.findById(id)
				.orElseThrow(() -> new CountryNotFoundException(
						String.format(THERE_IS_NO_REGISTRATION_OF_COUNTRY_WITH_CODE, id)));
	}

	public CountryModel findByIdDTO(String id) {
		return this.countryAssembler.toModel(this.findById(id));
	}

    public CollectionModel<CountryModel> listByFilter(CountryFilter countryFilter) {
		List<Country> countries = this.countryRepository.listByFilter(countryFilter);
		return this.countryAssembler.toCollectionModel(countries);
	}

}
