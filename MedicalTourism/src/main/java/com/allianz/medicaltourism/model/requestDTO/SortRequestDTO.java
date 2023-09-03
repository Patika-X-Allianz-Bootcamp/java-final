package com.allianz.medicaltourism.model.requestDTO;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class SortRequestDTO {
    private String columnName;
    private Sort.Direction directionEnum;
}
