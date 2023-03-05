package com.rgv04.hr.domain.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "countriesImages")
public class CountryImageModel extends RepresentationModel<CountryImageModel> {

    @EqualsAndHashCode.Include
    private String id;

    private String fileName;

    private String description;

    private String contentType;

    private Long size;

}
