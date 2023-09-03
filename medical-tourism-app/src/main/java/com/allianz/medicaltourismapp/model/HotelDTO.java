package com.allianz.medicaltourismapp.model;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;
import java.util.List;

@Data

public class HotelDTO extends BaseDTO {
    private String hotelName;
    private List<RoomDTO> roomNumbers;
    private String hotelAdress;

}
