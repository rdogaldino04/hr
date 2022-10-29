package com.rgv04.hr.domain.country.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.country.CountryAssembler;
import com.rgv04.hr.domain.country.CountryFilter;
import com.rgv04.hr.domain.country.CountryModel;
import com.rgv04.hr.domain.country.entity.Country;
import com.rgv04.hr.domain.country.service.CountryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/countries")
public class CountryController {

	private final CountryService countryService;

	private final CountryAssembler countryAssembler;

	@GetMapping
	public ResponseEntity<CollectionModel<CountryModel>> listByFilter(CountryFilter countryFilter) {
		List<Country> countries = this.countryService.listByFilter(countryFilter);
		CollectionModel<CountryModel> collectionModel = this.countryAssembler.toCollectionModel(countries);
		return ResponseEntity.ok(collectionModel);
	}

	@GetMapping("{id}")
	public ResponseEntity<CountryModel> findById(@PathVariable String id) {
		return ResponseEntity.ok(this.countryAssembler.toModel(countryService.findById(id)));
	}

}