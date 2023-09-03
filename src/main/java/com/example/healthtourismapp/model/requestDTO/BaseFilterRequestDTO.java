package com.example.healthtourismapp.model.requestDTO;
import com.example.healthtourismapp.model.SortDTO;
import com.example.healthtourismapp.util.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}
