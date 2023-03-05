package com.rgv04.hr.infrastructure.core;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import com.rgv04.hr.api.controller.JobHistoryController;

@Component
public class HrLinks {

    public Link linkToJobHistory(Long id, String rel) {
        
        return linkTo(methodOn(JobHistoryController.class).findById(id, rel)).withRel(rel);
    }
    
}
