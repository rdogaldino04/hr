package com.rgv04.hr.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryQueries {

    @Query("select e from Employee e where e.id = :id")
    EmployeeSumary listByIdSummary(Long id);

}
