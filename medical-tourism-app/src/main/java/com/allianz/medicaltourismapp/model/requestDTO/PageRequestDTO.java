package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;
@Data
public class PageRequestDTO<DTO extends BaseDTO>{

    private int TotalPages;
    private long TotalElements;
    private int number;
    private int size;
    private int numberOfElement;
    private List<DTO> content;
    private boolean hasContent;
    private Sort sort;
}

