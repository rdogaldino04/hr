package com.rgv04.hr.domain.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.region.assembler.RegionAssembler;
import com.rgv04.hr.domain.region.assembler.RegionWithCountryAssembler;
import com.rgv04.hr.domain.region.assembler.model.RegionModel;
import com.rgv04.hr.domain.region.assembler.model.RegionWithCountryModel;

@RestController
@RequestMapping("api/regions")
public class RegionController {

	@Autowired
	private RegionService regionService;

	@Autowired
	private RegionAssembler regionAssembler;

	@Autowired
	private RegionWithCountryAssembler regionWithCountryAssembler;

	@GetMapping
	public ResponseEntity<CollectionModel<RegionModel>> listByFilter(RegionFilter filter) {
		List<Region> listEntity = this.regionService.listByFilter(filter);
		CollectionModel<RegionModel> collectionModel = regionAssembler.toCollectionModel(listEntity);
		return ResponseEntity.ok(collectionModel);
	}

	@GetMapping("{id}")
	public ResponseEntity<RegionModel> findById(@PathVariable Long id) {
		Region region = this.regionService.findById(id);
		RegionModel regionDto = regionAssembler.toModel(region);
		return ResponseEntity.ok(regionDto);
	}

	@GetMapping("{regionId}/countries")
	public ResponseEntity<RegionWithCountryModel> countriesByRegionId(@PathVariable Long regionId) {
		Region regions = regionService.countriesByRegionId(regionId);		
		return ResponseEntity.ok(regionWithCountryAssembler.toModel(regions));
	}

}
