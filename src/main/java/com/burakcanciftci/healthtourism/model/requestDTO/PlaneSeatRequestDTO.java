package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlaneSeatRequestDTO extends BaseDTO {
    PlaneRequestDTO plane;
    String seatCode;
    BigDecimal ticketPrice;
}
