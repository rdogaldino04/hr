package com.rgv04.hr.domain.region;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.country.CountryAssembler;
import com.rgv04.hr.domain.country.CountryModel;

@RestController
@RequestMapping("api/regions")
public class RegionController {

	@Autowired
	private RegionService regionService;

	@Autowired
	private RegionAssembler regionAssembler;

	@Autowired
	private CountryAssembler countryAssembler;

	@PostMapping
	public ResponseEntity<RegionOutput> save(@RequestBody @Valid RegionInput regionInput) {
		Region region = toEntity(regionInput);
		region = regionService.save(region);
		RegionOutput regionOutput = toOutput(region);
		return ResponseEntity.ok(regionOutput);
	}

	@GetMapping
	public ResponseEntity<List<RegionModel>> listByFilter(RegionFilter filter) {
		List<Region> listEntity = this.regionService.listByFilter(filter);
		ArrayList<RegionModel> list = regionAssembler.toListModel(listEntity);
		return ResponseEntity.ok(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<RegionModel> findById(@PathVariable Long id) {
		Region region = this.regionService.findById(id);
		RegionModel regionDto = regionAssembler.toModel(region);
		return ResponseEntity.ok(regionDto);
	}

	@GetMapping("{regionId}/countries")
	public ResponseEntity<List<CountryModel>> findByCountries(@PathVariable Long regionId) {
		return ResponseEntity.ok(countryAssembler.toListModel(this.regionService.findByCountries(regionId)));
	}

	private RegionOutput toOutput(Region region) {
		RegionOutput regionOutput = new RegionOutput();
		regionOutput.setId(region.getId());
		regionOutput.setName(region.getName());
		return regionOutput;
	}

	private Region toEntity(RegionInput regionInput) {
		Region region = new Region();
		region.setName(regionInput.getName());
		return region;
	}

}
