package com.rgv04.hr.domain.jobhistory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.core.HrLinks;

@Component
public class JobHistoryModelAssembler extends RepresentationModelAssemblerSupport<JobHistory, JobHistoryModel> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
	private HrLinks hrLinks;

    public JobHistoryModelAssembler() {
        super(JobHistoryController.class, JobHistoryModel.class);
    }

    @Override
    public CollectionModel<JobHistoryModel> toCollectionModel(Iterable<? extends JobHistory> entities) {
        return super.toCollectionModel(entities);
    }

    @Override
    public JobHistoryModel toModel(JobHistory entity) {
        JobHistoryModel model = createModelWithId(entity.getJobHistoryID().getEmployeeId(), entity);
        modelMapper.map(entity, model);
        model.add(hrLinks.linkToJobHistory(entity.getJobHistoryID().getEmployeeId(), "job-histories"));
        return model;
    }

}
