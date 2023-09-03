package com.allianz.medicaltourismapp.util;

import com.allianz.medicaltourismapp.model.SortDTO;
import com.allianz.medicaltourismapp.util.dbutil.SearchCriteria;
import lombok.Data;

import java.util.List;
@Data
public class BaseFilterDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}
