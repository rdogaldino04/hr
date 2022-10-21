package com.rgv04.hr.employee;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeOnlyFirstNameAndHireDate {

    private String firstName;

    private OffsetDateTime hireDate;
    
}
