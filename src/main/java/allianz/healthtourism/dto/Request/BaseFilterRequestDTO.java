package allianz.healthtourism.dto.Request;

import allianz.healthtourism.dto.Response.SortDTO;
import allianz.healthtourism.util.SearchCriteria;
import lombok.Data;

import java.util.List;

@Data
public class BaseFilterRequestDTO {

    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
    private List<SearchCriteria> filters;
}
