package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.BookingPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.util.BaseRequestDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class HotelResponseDTO extends BaseResponseDTO {
    private String name;
    private BigDecimal price;
    private CityResponseDTO city;
    private List<PatientPlainResponseDTO> patients;
    private List<RoomResponseDTO> rooms;
}
