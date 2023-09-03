package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.model.SortDTO;
import com.allianz.healthtourismagency.util.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}