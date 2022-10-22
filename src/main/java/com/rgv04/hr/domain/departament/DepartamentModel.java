package com.rgv04.hr.domain.departament;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.rgv04.hr.domain.location.LocationModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Relation(collectionRelation = "departaments")
public class DepartamentModel extends RepresentationModel<DepartamentModel> {

    private Long id;

    private String name;

    private Long managerId;

    private LocationModel location;

}
