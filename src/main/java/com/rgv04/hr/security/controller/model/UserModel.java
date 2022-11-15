package com.rgv04.hr.security.controller.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "users")
public class UserModel extends RepresentationModel<UserModel> {
    
    private Long id;

    private String name;

    private String username;
    
}
