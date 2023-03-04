package com.rgv04.hr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.dto.RegionFilter;
import com.rgv04.hr.domain.dto.RegionModel;
import com.rgv04.hr.domain.dto.RegionWithCountryModel;
import com.rgv04.hr.domain.service.RegionService;

@RestController
@RequestMapping("api/regions")
public class RegionController {

	@Autowired
	private RegionService regionService;

	@GetMapping
	public ResponseEntity<CollectionModel<RegionModel>> listByFilter(RegionFilter filter) {
		return ResponseEntity.ok(this.regionService.listByFilter(filter));
	}

	@GetMapping("{id}")
	public ResponseEntity<RegionModel> findById(@PathVariable Long id) {
		return ResponseEntity.ok(this.regionService.findById(id));
	}

	@GetMapping("{regionId}/countries")
	public ResponseEntity<RegionWithCountryModel> countriesByRegionId(@PathVariable Long regionId) {
		return ResponseEntity.ok(regionService.countriesByRegionId(regionId));
	}

}
