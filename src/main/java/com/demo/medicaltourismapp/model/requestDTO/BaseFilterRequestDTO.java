package com.demo.medicaltourismapp.model.requestDTO;

import com.demo.medicaltourismapp.model.SortDTO;
import lombok.Data;

@Data
public class BaseFilterRequestDTO {

    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;

}
