package com.rgv04.hr.domain.country.controller.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

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
@Relation(collectionRelation = "countriesImages")
public class CountryImageModel extends RepresentationModel<CountryImageModel> {

    private String id;

    private String fileName;

    private String description;

    private String contentType;

    private Long size;

}
