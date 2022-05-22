package com.rgv04.hr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.controller.assembler.CountryAssembler;
import com.rgv04.hr.controller.assembler.RegionAssembler;
import com.rgv04.hr.model.Country;
import com.rgv04.hr.model.Region;
import com.rgv04.hr.model.dto.CountryDTO;
import com.rgv04.hr.model.dto.RegionDTO;
import com.rgv04.hr.model.filter.RegionFilter;
import com.rgv04.hr.service.CountryService;
import com.rgv04.hr.service.RegionService;

@RestController
@RequestMapping("regions")
public class RegionController {

	@Autowired
	private RegionService regionService;
	
	@Autowired
	private CountryService countryService;

	@Autowired
	private RegionAssembler regionAssembler;
	
	@Autowired
	private CountryAssembler countryAssembler;

	@GetMapping
	public ResponseEntity<List<RegionDTO>> listByFilter(RegionFilter filter) {
		List<Region> listEntity = this.regionService.listByFilter(filter);
		ArrayList<RegionDTO> list = regionAssembler.toListDto(listEntity);
		return ResponseEntity.ok(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<RegionDTO> getById(@PathVariable Long id) {
		Region region = this.regionService.byId(id);
		RegionDTO regionDto = regionAssembler.toDto(region);
		return ResponseEntity.ok(regionDto);
	}
	
	@GetMapping("{regionId}/country")
	public ResponseEntity<List<CountryDTO>> findByRegion(@PathVariable Long regionId) {
		List<Country> countries = this.countryService.findByRegion(regionId);
		List<CountryDTO> countriesDto = countryAssembler.toListDto(countries);
		return ResponseEntity.ok(countriesDto);
	}
	
	@GetMapping("{regionId}/country/{countryId}")
	public ResponseEntity<CountryDTO> findByCountry(@PathVariable Long regionId, @PathVariable String countryId) {
		RegionFilter regionFilter = new RegionFilter(regionId, countryId);
		Region region = this.regionService.byCountry(regionFilter);
		RegionDTO regionDTO = this.regionAssembler.toDto(region);
		CountryDTO countryDTO = regionDTO.getCountries().get(0);
		return ResponseEntity.ok(countryDTO);
	}

}
