package com.rgv04.hr.security.model;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String username;
    private String password;
    private Collection<Role> roles = new ArrayList<Role>();

}
