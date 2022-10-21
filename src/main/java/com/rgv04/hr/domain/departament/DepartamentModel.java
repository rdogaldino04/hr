package com.rgv04.hr.domain.departament;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartamentModel {

    private Long id;

    private String name;

    private Long managerId;
    
}
