package com.rgv04.hr.api.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.dto.CountryFilter;
import com.rgv04.hr.domain.dto.CountryModel;
import com.rgv04.hr.domain.service.CountryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/countries")
public class CountryController {

	private final CountryService countryService;

	@GetMapping
	public ResponseEntity<CollectionModel<CountryModel>> listByFilter(CountryFilter countryFilter) {
		CollectionModel<CountryModel> collectionModel = this.countryService.listByFilter(countryFilter);
		return ResponseEntity.ok(collectionModel);
	}

	@GetMapping("{id}")
	public ResponseEntity<CountryModel> findById(@PathVariable String id) {
		return ResponseEntity.ok(countryService.findByIdDTO(id));
	}

}
