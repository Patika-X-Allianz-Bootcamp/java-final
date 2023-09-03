package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.model.SeatDTO;
import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

@Data

public class SeatRequestDTO extends BaseDTO {

    private int seatNumber;

    private boolean isReserved;

}
