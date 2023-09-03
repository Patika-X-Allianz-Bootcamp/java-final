package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class HotelRequestDTO extends BaseDTO {

private String city;
private int capacity;
@JsonIgnore
private List<RoomRequestDTO> roomList;

}
