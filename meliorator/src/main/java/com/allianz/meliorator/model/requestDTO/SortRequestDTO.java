package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class SortRequestDTO extends BaseRequestDTO {
    private String columnName;
    private Sort.Direction directionEnum;
}
