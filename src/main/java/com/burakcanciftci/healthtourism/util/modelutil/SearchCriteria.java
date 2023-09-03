package com.burakcanciftci.healthtourism.util.modelutil;

import lombok.Data;

@Data
public class SearchCriteria {

    private String key;
    private String operation;
    private Object value;

}