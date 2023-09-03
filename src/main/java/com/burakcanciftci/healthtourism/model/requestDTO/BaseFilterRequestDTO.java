package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.model.SortDTO;
import com.burakcanciftci.healthtourism.util.modelutil.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}
