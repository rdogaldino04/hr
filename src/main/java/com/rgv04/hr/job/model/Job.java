package com.rgv04.hr.job.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {
    
    @Id
    @Column(name = "job_id")
    private String id;
    
    @Column(name = "job_title")
    private String title;
    
    private Long minSalary;
    
    private Long maxSalary;

}
