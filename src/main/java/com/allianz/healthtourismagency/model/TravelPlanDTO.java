package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.model.enums.FlightTypeEnum;
import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class TravelPlanDTO extends BaseDTO {

public FlightTypeEnum flightType;
public List<FlightDTO> flightList;
public List<SeatDTO> seatList;
public HotelDTO hotel;
public RoomDTO room;

}
