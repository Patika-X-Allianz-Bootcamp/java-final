package com.allianz.meliorator.util;

import com.allianz.meliorator.model.dto.SortDTO;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    public List<SearchCriteria> getFilters() {
        return null;
    }
}
