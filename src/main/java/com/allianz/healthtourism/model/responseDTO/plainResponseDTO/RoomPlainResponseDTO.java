package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.model.responseDTO.BookingForPatientResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class RoomPlainResponseDTO extends BaseResponseDTO {
    private int roomNo;
    private List<BookingForPatientResponseDTO> bookings;
}
