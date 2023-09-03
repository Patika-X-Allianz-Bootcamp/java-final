package com.allianz.medicaltourismapp.model.requestDTO;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

@Data

public class SeatRequestDTO extends BaseDTO {
    private FlightRequestDTO flight;
    private char layoutLetter;
    private int layoutNumber;

}
