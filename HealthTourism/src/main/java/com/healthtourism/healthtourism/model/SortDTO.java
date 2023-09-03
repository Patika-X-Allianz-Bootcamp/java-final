package com.healthtourism.healthtourism.model;

import lombok.Data;
import org.springframework.data.domain.Sort;
@Data
public class SortDTO {
    private String columnName;
    private Sort.Direction directionEnum;

}
