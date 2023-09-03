package com.allianz.medicaltourismapp.model;

import lombok.Data;
import org.springframework.data.domain.Sort;
@Data
public class SortDTO {
    private String coloumnName;
    private Sort.Direction direction;

}
