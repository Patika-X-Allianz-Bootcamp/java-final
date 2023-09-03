package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class TestResultRequestDTO extends BaseDTO {

    private String testName;
    private String result;
    private Date resultDate;

}
