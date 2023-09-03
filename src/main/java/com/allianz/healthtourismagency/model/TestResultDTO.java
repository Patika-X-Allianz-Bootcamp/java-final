package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class TestResultDTO extends BaseDTO {

    private String testName;
    private String result;
    private Date resultDate;

}
