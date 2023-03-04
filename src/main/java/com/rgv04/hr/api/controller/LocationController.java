package com.rgv04.hr.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.location.Location;
import com.rgv04.hr.domain.location.LocationAssembler;
import com.rgv04.hr.domain.location.LocationFilter;
import com.rgv04.hr.domain.location.LocationModel;
import com.rgv04.hr.domain.location.LocationService;

@RestController
@RequestMapping("api/locations")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private LocationAssembler locationAssembler;
    
    @GetMapping
    public ResponseEntity<CollectionModel<LocationModel>> ListByFilter(LocationFilter filter) {
    	List<Location> locations = this.locationService.ListByFilter(filter);
    	CollectionModel<LocationModel> collectionModel = locationAssembler.toCollectionModel(locations);
        return ResponseEntity.ok(collectionModel);
    }

	@GetMapping("{id}")
    public ResponseEntity<LocationModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(locationAssembler.toModel(locationService.findById(id)));
    }

}