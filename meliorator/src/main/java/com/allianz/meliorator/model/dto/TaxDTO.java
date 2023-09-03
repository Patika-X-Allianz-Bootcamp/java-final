package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxDTO extends BaseDTO {
    private String name;
    private BigDecimal rate;
}
