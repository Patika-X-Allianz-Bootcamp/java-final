package com.tourismcorp.healthtourism.model;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

@Data

public class SeatDTO extends BaseDTO {

    private int seatNumber;

    private boolean isReserved;

}
