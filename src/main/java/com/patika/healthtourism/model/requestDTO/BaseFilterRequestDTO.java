package com.patika.healthtourism.model.requestDTO;

import com.patika.healthtourism.model.SortDTO;
import com.patika.healthtourism.util.BaseDTO;
import com.patika.healthtourism.util.BaseRequestDTO;
import lombok.Data;

@Data
public class BaseFilterRequestDTO extends BaseRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
}