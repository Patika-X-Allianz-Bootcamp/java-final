package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.Date;
@Data
public class HotelReservationDTO extends BaseDTO {

    private Date startDate;
    private Date endDate;

}
