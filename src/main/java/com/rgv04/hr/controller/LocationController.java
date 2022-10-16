package com.rgv04.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.controller.assembler.LocationAssembler;
import com.rgv04.hr.model.Location;
import com.rgv04.hr.model.dto.LocationDTO;
import com.rgv04.hr.model.filter.LocationFilter;
import com.rgv04.hr.service.LocationService;

@RestController
@RequestMapping("locations")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private LocationAssembler locationAssembler;
    
    @GetMapping
    public List<LocationDTO> findByFilter(LocationFilter filter) {
    	List<Location> findByFilter = this.locationService.findByFilter(filter);
    	List<LocationDTO> listDto = locationAssembler.toListModel(findByFilter);
        return listDto;
    }
}
