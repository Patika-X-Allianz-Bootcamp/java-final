package com.allianz.patienttourism.model.requestDTO;

import com.allianz.patienttourism.model.SortDTO;
import com.allianz.patienttourism.util.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}
