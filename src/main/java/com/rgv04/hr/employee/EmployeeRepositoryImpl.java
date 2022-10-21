package com.rgv04.hr.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class EmployeeRepositoryImpl implements EmployeeRepositoryQueries {

    @PersistenceContext
	private EntityManager manager;

    @Override
    public List<EmployeeOnlyFirstNameAndHireDate> listByJoinedYear(EmployeeFilter filter) {
        StringBuilder sql = 
            new StringBuilder("select ")
                .append("new com.rgv04.hr.employee.EmployeeOnlyFirstNameAndHireDate(e.firstName, e.hireDate) ")
                .append(" from Employee e ")
                .append("where extract(year from e.hireDate) between :startYear and :endYear");
        TypedQuery<EmployeeOnlyFirstNameAndHireDate> createQuery = 
            manager.createQuery(sql.toString(), EmployeeOnlyFirstNameAndHireDate.class)
            .setParameter("startYear", filter.getStartYear())
            .setParameter("endYear", filter.getEndYear());
        return createQuery.getResultList();
    }
    
}
