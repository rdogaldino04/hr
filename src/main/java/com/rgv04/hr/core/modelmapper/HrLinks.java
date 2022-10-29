package com.rgv04.hr.core.modelmapper;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.TemplateVariable;
import org.springframework.hateoas.TemplateVariable.VariableType;
import org.springframework.hateoas.TemplateVariables;
import org.springframework.hateoas.UriTemplate;
import org.springframework.stereotype.Component;

import com.rgv04.hr.domain.jobhistory.JobHistoryController;

@Component
public class HrLinks {

    public Link linkToJobHistory(Long id, String rel) {
        
        return linkTo(methodOn(JobHistoryController.class).findById(id, rel)).withRel(rel);
    }
    
}
