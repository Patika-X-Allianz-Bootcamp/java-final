package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Data
public class HotelRoomRequestDTO extends BaseDTO {
    HotelRequestDTO hotel;
    String doorCode;
    String roomType;
    BigDecimal pricePerNight;
    Integer totalDayCount;
    List<LocalDate> availableDateList = new ArrayList<>();
    List<RoomReservationRequestDTO> roomReservationList = new ArrayList<>();
}
