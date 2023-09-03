package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.model.SortDTO;
import com.tourismcorp.healthtourism.util.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}
