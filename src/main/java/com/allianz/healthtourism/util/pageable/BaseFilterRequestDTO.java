package com.allianz.healthtourism.util.pageable;

import com.allianz.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO extends BaseRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}

