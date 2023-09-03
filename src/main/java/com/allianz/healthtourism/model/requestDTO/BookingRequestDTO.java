package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingRequestDTO extends BaseRequestDTO {
    private LocalDate bookingDate;
    private Long hotelId;
    private Long patientId;
    private Long roomId;
}
