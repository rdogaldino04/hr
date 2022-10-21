package com.rgv04.hr.employee;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFilter {

    @NotNull
    private int startYear;

    @NotNull
    private int endYear;

}
