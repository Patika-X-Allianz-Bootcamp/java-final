package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.RoomPlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingForPatientResponseDTO extends BaseResponseDTO {
    private LocalDate bookingDate;
}
