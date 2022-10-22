package com.rgv04.hr.domain.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;
import com.rgv04.hr.domain.country.Country;
import com.rgv04.hr.domain.country.CountryModel;
import com.rgv04.hr.domain.departament.Departament;
import com.rgv04.hr.domain.departament.DepartamentAssembler;
import com.rgv04.hr.domain.departament.DepartamentModel;
import com.rgv04.hr.domain.job.controller.assembler.JobAssembler;
import com.rgv04.hr.domain.job.controller.model.JobModel;
import com.rgv04.hr.domain.location.Location;
import com.rgv04.hr.domain.location.LocationModel;
import com.rgv04.hr.domain.region.Region;
import com.rgv04.hr.domain.region.assembler.model.RegionModel;

@Component
public class EmployeeAssembler implements Assembler<Employee, EmployeeModel> {

	@Autowired
	private JobAssembler jobAssembler;

	@Autowired
	private DepartamentAssembler departamentAssembler;

	@Override
	public List<EmployeeModel> toListModel(List<Employee> entities) {
		if (entities != null && entities.size() > 0) {
			return entities.stream().map(entity -> {
				if (entity.getEmployeeManager() == null) {
					entity.setEmployeeManager(new Employee());
				}
				if (entity.getEmployeeManager().getDepartament() == null) {
					entity.getEmployeeManager().setDepartament(new Departament());
				}
				if (entity.getEmployeeManager().getDepartament().getLocation() == null) {
					entity.getEmployeeManager().getDepartament().setLocation(new Location());
				}
				if (entity.getEmployeeManager().getDepartament().getLocation().getCountry() == null) {
					entity.getEmployeeManager().getDepartament().getLocation().setCountry(new Country());
				}
				if (entity.getEmployeeManager().getDepartament().getLocation().getCountry().getRegion() == null) {
					entity.getEmployeeManager().getDepartament().getLocation().getCountry().setRegion(new Region());
				}
				return EmployeeModel
						.builder()
						.id(entity.getId())
						.firstName(entity.getFirstName())
						.lastName(entity.getLastName())
						.email(entity.getEmail())
						.phoneNumber(entity.getPhoneNumber())
						.hireDate(entity.getHireDate())
						.job(JobModel.builder()
								.id(entity.getJob().getId())
								.title(entity.getJob().getTitle())
								.minSalary(entity.getJob().getMinSalary())
								.maxSalary(entity.getJob().getMaxSalary())
								.build())
						.salary(entity.getSalary())
						.employeeManager(EmployeeManagerModel.builder()
								.id(entity.getEmployeeManager().getId())
								.firstName(entity.getEmployeeManager().getFirstName())
								.lastName(entity.getEmployeeManager().getLastName())
								.email(entity.getEmployeeManager().getEmail())
								.phoneNumber(entity.getEmployeeManager().getPhoneNumber())
								.hireDate(entity.getEmployeeManager().getHireDate())
								.salary(entity.getEmployeeManager().getSalary())
								.commissionPct(entity.getEmployeeManager().getCommissionPct())
								.departament(DepartamentModel.builder()
										.id(entity.getEmployeeManager().getDepartament().getId())
										.name(entity.getEmployeeManager().getDepartament().getName())
										.managerId(entity.getEmployeeManager().getDepartament().getManagerId())
										.location(LocationModel.builder()
												.id(entity.getEmployeeManager().getDepartament().getLocation().getId())
												.streetAddress(entity.getEmployeeManager().getDepartament().getLocation().getStreetAddress())
												.postalCode(entity.getEmployeeManager().getDepartament().getLocation().getPostalCode())
												.city(entity.getEmployeeManager().getDepartament().getLocation().getCity())
												.stateProvince(entity.getEmployeeManager().getDepartament().getLocation().getStateProvince())
												.country(CountryModel.builder()
														.id(entity.getEmployeeManager().getDepartament().getLocation().getCountry().getId())
														.name(entity.getEmployeeManager().getDepartament().getLocation().getCountry().getName())
														.region(RegionModel.builder()
																.id(entity.getEmployeeManager().getDepartament().getLocation().getCountry().getRegion().getId())
																.name(entity.getEmployeeManager().getDepartament().getLocation().getCountry().getRegion().getName())
																.build())
														.build())

												.build())
										.build())		// TODO						
								.build())
						.commissionPct(entity.getCommissionPct())
						.departament(this.departamentAssembler.toModel(entity.getDepartament()))
						.build();
			}).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	@Override
	public EmployeeModel toModel(Employee entity) {
		return EmployeeModel
				.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber())
				.hireDate(entity.getHireDate())
				.job(this.jobAssembler.toModel(entity.getJob()))
				.salary(entity.getSalary())
				.employeeManager(createEmployeeManager(entity.getEmployeeManager()))
				.commissionPct(entity.getCommissionPct())
				.departament(this.departamentAssembler.toModel(entity.getDepartament()))
				.build();
	}

	private EmployeeManagerModel createEmployeeManager(Employee entity) {
		if (entity == null) {
			return EmployeeManagerModel.builder()
					.id(null)
					.firstName(null)
					.lastName(null)
					.email(null)
					.phoneNumber(null)
					.hireDate(null)
					.salary(null)
					.commissionPct(null)
					.departament(null)
					.build();
		}
		return EmployeeManagerModel.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber())
				.hireDate(entity.getHireDate())
				.salary(entity.getSalary())
				.commissionPct(entity.getCommissionPct())
				.departament(departamentAssembler.toModel(entity.getDepartament()))
				.build();
	}

}
