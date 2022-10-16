package com.rgv04.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.controller.assembler.LocationAssembler;
import com.rgv04.hr.controller.model.LocationModel;
import com.rgv04.hr.model.Location;
import com.rgv04.hr.model.filter.LocationFilter;
import com.rgv04.hr.service.LocationService;

@RestController
@RequestMapping("api/locations")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private LocationAssembler locationAssembler;
    
    @GetMapping
    public ResponseEntity<List<LocationModel>> ListByFilter(LocationFilter filter) {
    	List<Location> locations = this.locationService.ListByFilter(filter);
    	List<LocationModel> listDtos = locationAssembler.toListModel(locations);
        return ResponseEntity.ok(listDtos);
    }

	@GetMapping("{id}")
    public ResponseEntity<LocationModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(locationAssembler.toModel(locationService.findById(id)));
    }

}
