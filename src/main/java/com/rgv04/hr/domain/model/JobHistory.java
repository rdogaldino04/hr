package com.rgv04.hr.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class JobHistory {

    @EmbeddedId
    private JobHistoryID jobHistoryID;

    private OffsetDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departament departament;
    
}
