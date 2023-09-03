package com.allianz.healthtourism.util.pageable;

import lombok.Data;

@Data
public class SearchCriteria {

    private String key;
    private String operation;
    private Object value;

}
