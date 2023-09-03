package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.model.FlightDTO;
import com.allianz.healthtourismagency.model.HotelDTO;
import com.allianz.healthtourismagency.model.RoomDTO;
import com.allianz.healthtourismagency.model.SeatDTO;
import com.allianz.healthtourismagency.model.enums.FlightTypeEnum;
import com.allianz.healthtourismagency.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class TravelPlanRequestDTO extends BaseDTO {

    public FlightTypeEnum flightType;
    @JsonIgnore
    public List<FlightDTO> flightList;
    @JsonIgnore
    public List<SeatDTO> seatList;
    @JsonIgnore
    public HotelDTO hotel;
    @JsonIgnore
    public RoomDTO room;

}
