package com.allianz.medicaltourismapp.model;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

@Data

public class CreditCardDTO extends BaseDTO {
    private String clientName;
    private String ccNumber;
    private int ccBudget;
    private int exDate;
    private int ccPassword;


}
