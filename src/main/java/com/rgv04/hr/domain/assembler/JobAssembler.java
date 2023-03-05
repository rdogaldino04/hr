package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.api.controller.JobController;
import com.rgv04.hr.domain.dto.JobModel;
import com.rgv04.hr.domain.model.Job;

@Component
public class JobAssembler extends RepresentationModelAssemblerSupport<Job, JobModel> {

    @Autowired
	private ModelMapper modelMapper;

    public JobAssembler() {
        super(JobController.class, JobModel.class);
    }

    @Override
    public CollectionModel<JobModel> toCollectionModel(Iterable<? extends Job> entities) {        
        return super.toCollectionModel(entities);
    }

    @Override
    public JobModel toModel(Job entity) {
        JobModel model = createModelWithId(entity.getId(), entity);
        modelMapper.map(entity, model);
        return model;
    }
    
}
