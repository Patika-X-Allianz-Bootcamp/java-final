package com.allianz.HealthTourismSpringBoot.model.requestDTO;

import com.allianz.HealthTourismSpringBoot.model.SortDTO;
import com.allianz.HealthTourismSpringBoot.util.SearchCriteria;
import lombok.Data;

import java.util.List;
@Data
public class BaseFilterRequestDTO {

    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}
