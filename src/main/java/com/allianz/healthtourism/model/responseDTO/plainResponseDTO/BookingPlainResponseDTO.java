package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.model.responseDTO.PatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.RoomResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingPlainResponseDTO extends BaseResponseDTO {
    private BigDecimal price;
    private LocalDate bookingDate;
    private PatientPlainResponseDTO patient;
    private RoomPlainResponseDTO room;
}
