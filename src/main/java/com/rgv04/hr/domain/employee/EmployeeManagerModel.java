package com.rgv04.hr.domain.employee;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.rgv04.hr.domain.departament.DepartamentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "employeeManagers")
public class EmployeeManagerModel extends RepresentationModel<EmployeeManagerModel> {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private OffsetDateTime hireDate;

	private BigDecimal salary;

	private BigDecimal commissionPct;

	private DepartamentModel departament;

}
