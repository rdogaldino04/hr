package com.rgv04.hr.domain.dto;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeOnlyFirstNameAndHireDate {

    private String firstName;

    private OffsetDateTime hireDate;
    
}
