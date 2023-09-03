package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;
@Data
public class PageRequestDTO<DTO extends BaseRequestDTO> {

        private int number;
        private int size;
        private int totalPages;
        private Long totalElements;
        private boolean hasContent;
        private List<DTO> content;
        private Sort sort;
}
