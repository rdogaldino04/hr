package com.rgv04.hr.domain.employee;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFilter {

    @NotNull
    private Long startYear;

    @NotNull
    private Long endYear;

}
