package com.rgv04.hr.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartamentDTO {

    private Long id;

    private String name;

    private Long managerId;
    
}
