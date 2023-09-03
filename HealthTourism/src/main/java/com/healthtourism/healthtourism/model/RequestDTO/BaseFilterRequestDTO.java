package com.healthtourism.healthtourism.model.RequestDTO;

import com.healthtourism.healthtourism.model.SortDTO;
import com.healthtourism.healthtourism.util.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {

    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;

}
