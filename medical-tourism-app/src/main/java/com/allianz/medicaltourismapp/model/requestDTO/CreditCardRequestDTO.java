package com.allianz.medicaltourismapp.model.requestDTO;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

@Data
public class CreditCardRequestDTO extends BaseDTO {
    private String clientName;
    private String ccNumber;
    private int ccBudget;
    private int exDate;
    private int ccPassword;


}
