package com.rgv04.hr.domain.employee;

import java.util.List;

public interface EmployeeRepositoryQueries {

    List<EmployeeOnlyFirstNameAndHireDate> listByJoinedYear(EmployeeFilter filter);

}
