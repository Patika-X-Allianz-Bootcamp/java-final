package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelDTO extends BaseDTO {
	private String name;
	private String address;
	private List<HotelRoomDTO> hotelRooms;
}
