package com.rgv04.hr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.dto.LocationFilter;
import com.rgv04.hr.domain.dto.LocationModel;
import com.rgv04.hr.domain.service.LocationService;

@RestController
@RequestMapping("api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<CollectionModel<LocationModel>> listByFilter(LocationFilter filter) {
        return ResponseEntity.ok(this.locationService.listByFilter(filter));
    }

    @GetMapping("{id}")
    public ResponseEntity<LocationModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.findById(id));
    }

}
