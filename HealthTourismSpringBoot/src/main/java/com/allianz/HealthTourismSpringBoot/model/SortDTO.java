package com.allianz.HealthTourismSpringBoot.model;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class SortDTO {
    private String columnName;
    private Sort.Direction directionEnum;
}
