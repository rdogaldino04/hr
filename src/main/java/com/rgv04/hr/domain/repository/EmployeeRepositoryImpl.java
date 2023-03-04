package com.rgv04.hr.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rgv04.hr.domain.dto.EmployeeFilter;
import com.rgv04.hr.domain.dto.EmployeeOnlyFirstNameAndHireDate;

public class EmployeeRepositoryImpl implements EmployeeRepositoryQueries {

    @PersistenceContext
	private EntityManager manager;

    @Override
    public List<EmployeeOnlyFirstNameAndHireDate> listByJoinedYear(EmployeeFilter filter) {
        StringBuilder sql = 
            new StringBuilder("select ")
                .append("new com.rgv04.hr.domain.employee.EmployeeOnlyFirstNameAndHireDate(e.firstName, e.hireDate) ")
                .append(" from Employee e ")
                .append("where extract(year from e.hireDate) between :startYear and :endYear");
        TypedQuery<EmployeeOnlyFirstNameAndHireDate> createQuery = 
            manager.createQuery(sql.toString(), EmployeeOnlyFirstNameAndHireDate.class)
            .setParameter("startYear", filter.getStartYear().intValue())
            .setParameter("endYear", filter.getEndYear().intValue());
        return createQuery.getResultList();
    }
    
}
