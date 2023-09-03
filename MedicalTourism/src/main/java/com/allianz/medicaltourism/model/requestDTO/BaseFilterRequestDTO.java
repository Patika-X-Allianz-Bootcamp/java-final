package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.model.DTO.SortDTO;
import com.allianz.medicaltourism.util.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}
