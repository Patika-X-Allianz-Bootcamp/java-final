package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.model.enums.OccupancyStatusEnum;
import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

@Data
public class SeatDTO extends BaseDTO {

    private int seatNumber;
    private OccupancyStatusEnum occupancyStatus;

}
