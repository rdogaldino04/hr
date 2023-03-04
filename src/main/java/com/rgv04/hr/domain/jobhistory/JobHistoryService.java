package com.rgv04.hr.domain.jobhistory;

import java.time.OffsetDateTime;

import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import com.rgv04.hr.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JobHistoryService {

    private final JobHistoryRepository jobHistoryRepository;

    private final JobHistoryModelAssembler jobHistoryAssembler;

    public CollectionModel<JobHistoryModel> getAll() {
        return jobHistoryAssembler.toCollectionModel(this.jobHistoryRepository.getAll());
    }

    public JobHistoryModel findById(Long employeeId, String startDate) {
        JobHistoryID jobHistoryPK = new JobHistoryID(employeeId, OffsetDateTime.parse(startDate));
        return jobHistoryAssembler.toModel(this.jobHistoryRepository.findById(jobHistoryPK)
                .orElseThrow(() -> new BusinessException("Resource not found")));
    }

}
