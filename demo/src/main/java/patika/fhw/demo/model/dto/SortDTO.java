package patika.fhw.demo.model.dto;

import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class SortDTO {
    private String columnName;
    private Sort.Direction directionEnum;
}