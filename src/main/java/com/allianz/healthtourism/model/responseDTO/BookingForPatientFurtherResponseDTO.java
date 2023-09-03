package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HotelPlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingForPatientFurtherResponseDTO extends BaseResponseDTO {
    private BigDecimal price;
    private LocalDate bookingDate;
    private HotelPlainResponseDTO hotel;
    private RoomResponseDTO room;
}
