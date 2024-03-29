package com.rgv04.hr.domain.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.api.controller.JobHistoryController;
import com.rgv04.hr.domain.model.JobHistory;
import com.rgv04.hr.domain.model.JobHistoryModel;
import com.rgv04.hr.infrastructure.core.HrLinks;

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
    public JobHistoryModel toModel(JobHistory entity) {
        JobHistoryModel model = createModelWithId(entity.getJobHistoryID().getEmployeeId(), entity);
        modelMapper.map(entity, model);
        model.add(hrLinks.linkToJobHistory(entity.getJobHistoryID().getEmployeeId(), "job-histories"));
        return model;
    }

}
