package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelRequestDTO extends BaseDTO {
	private String name;
	private String address;
	private List<HotelRoomRequestDTO> hotelRooms;
}
