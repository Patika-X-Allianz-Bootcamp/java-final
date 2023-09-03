package com.allianz.healthtourism.util;

import lombok.Data;

@Data
public class SearchCriteria {

    private String key;  //column adı
    private String operation;  // =, <, >, <=, ....
    private Object value;

}
