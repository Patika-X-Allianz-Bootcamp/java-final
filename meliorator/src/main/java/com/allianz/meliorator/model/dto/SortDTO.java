package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.util.BaseDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class SortDTO extends BaseDTO{
    private String columnName;
    private Sort.Direction directionEnum;
}
