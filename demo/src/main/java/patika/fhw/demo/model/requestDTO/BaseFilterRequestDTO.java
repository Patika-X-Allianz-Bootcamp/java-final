package patika.fhw.demo.model.requestDTO;
import java.util.List;

import lombok.Data;
import patika.fhw.demo.model.dto.SortDTO;
import patika.fhw.demo.util.SearchCriteria;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}