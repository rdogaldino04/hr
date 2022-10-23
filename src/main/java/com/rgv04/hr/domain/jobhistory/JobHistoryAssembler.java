package com.rgv04.hr.domain.jobhistory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class JobHistoryAssembler extends RepresentationModelAssemblerSupport<JobHistory, JobHistoryModel> {

    @Autowired
    private ModelMapper modelMapper;

    public JobHistoryAssembler() {
        super(JobHistoryController.class, JobHistoryModel.class);
    }

    @Override
    public CollectionModel<JobHistoryModel> toCollectionModel(Iterable<? extends JobHistory> entities) {
        return super.toCollectionModel(entities);
    }

    @Override
    public JobHistoryModel toModel(JobHistory entity) {
        JobHistoryModel model = createModelWithId(entity.getJobHistoryID(), entity);
        modelMapper.map(entity, model);
        return model;
    }

}
