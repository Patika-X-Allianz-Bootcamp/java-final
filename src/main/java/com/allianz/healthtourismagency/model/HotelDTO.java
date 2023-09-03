package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class HotelDTO extends BaseDTO {

private String city;
private int capacity;
@JsonIgnore
private List<RoomDTO> roomList;

}
