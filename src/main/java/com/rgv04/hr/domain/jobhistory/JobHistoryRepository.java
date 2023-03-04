package com.rgv04.hr.domain.jobhistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryID> {

    @Query("select jh from JobHistory jh " +
            "left join fetch jh.job j " +
            "left join fetch jh.departament dep " +
            "left join fetch dep.location loc " +
            "left join fetch loc.country cou " +
            "left join fetch cou.region reg ")
    List<JobHistory> getAll();

}
