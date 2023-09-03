package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.Date;
@Data
public class HotelReservationRequestDTO extends BaseDTO {

    private Date startDate;
    private Date endDate;

}
