package com.rgv04.hr.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Embeddable
public class JobHistoryPK implements Serializable {

    @EqualsAndHashCode.Include
    private Long employeeId;

    @EqualsAndHashCode.Include
    private OffsetDateTime startDate;
    
}
