package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxRequestDTO extends BaseRequestDTO {
    private String name;
    private BigDecimal rate;
}
