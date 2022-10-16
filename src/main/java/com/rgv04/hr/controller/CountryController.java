package com.rgv04.hr.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.controller.assembler.CountryAssembler;
import com.rgv04.hr.controller.model.CountryModel;
import com.rgv04.hr.model.Country;
import com.rgv04.hr.model.filter.CountryFilter;
import com.rgv04.hr.service.CountryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("countries")
public class CountryController {

	private final CountryService countryService;

	private final CountryAssembler countryAssembler;
	

	@GetMapping
	public ResponseEntity<List<CountryModel>> findAll(CountryFilter countryFilter) {
		List<Country> countries = this.countryService.findAll(countryFilter);
		List<CountryModel> countryDTOs = this.countryAssembler.toListDto(countries);
		return ResponseEntity.ok(countryDTOs);
	}

	@GetMapping("{id}")
	public ResponseEntity<CountryModel> findById(@PathVariable String id) {
		return ResponseEntity.ok(this.countryAssembler.toDto(countryService.findById(id)));
	}

}
