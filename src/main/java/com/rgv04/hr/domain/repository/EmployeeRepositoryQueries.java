package com.rgv04.hr.domain.repository;

import java.util.List;

import com.rgv04.hr.domain.dto.EmployeeFilter;
import com.rgv04.hr.domain.dto.EmployeeOnlyFirstNameAndHireDate;

public interface EmployeeRepositoryQueries {

    List<EmployeeOnlyFirstNameAndHireDate> listByJoinedYear(EmployeeFilter filter);

}
