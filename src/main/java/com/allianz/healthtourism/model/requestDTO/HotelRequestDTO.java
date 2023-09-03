package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelRequestDTO extends BaseDTO {

    private String name;

    private List<RoomRequestDTO> rooms;

    private CityRequestDTO city;

    private List<PatientRequestDTO> patientList;
}