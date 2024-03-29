package com.rgv04.hr.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rgv04.hr.domain.dto.EmployeeSumary;
import com.rgv04.hr.domain.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryQueries {

    @Query("select e " + 
        "from Employee e " +
        "join fetch e.job j " +
        "left join fetch e.employeeManager em " +
        "left join fetch e.departament d " +
        "left join fetch d.location l " +
        "left join fetch l.country c " +
        "left join fetch c.region r " +
        "where e.id = :id ")
    Optional<Employee> findById(Long id);

    @Query("select e " + 
        "from Employee e " +
        "join fetch e.job j " +
        "left join fetch e.employeeManager em " +
        "left join fetch e.departament d " +
        "left join fetch d.location l " +
        "left join fetch l.country c " +
        "left join fetch c.region r ")
    List<Employee> findAll();

    @Query("select e from Employee e where e.id = :id")
    EmployeeSumary listByIdSummary(Long id);

}
