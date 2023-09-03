package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class HotelRoomResponseDTO extends BaseDTO {
    HotelResponseDTO hotel;
    String doorCode;
    String roomType;
    BigDecimal pricePerNight;
    List<LocalDate> availableDateList = new ArrayList<>();
    List<RoomReservationResponseDTO> roomReservationList = new ArrayList<>();
}
