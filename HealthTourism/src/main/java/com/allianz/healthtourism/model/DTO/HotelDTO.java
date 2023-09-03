package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.model.requestDTO.CityRequestDTO;
import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelDTO extends BaseDTO {

    private String name;

    private List<RoomDTO> rooms;

    private CityDTO city;

    private List<PatientDTO> patientList;
}
