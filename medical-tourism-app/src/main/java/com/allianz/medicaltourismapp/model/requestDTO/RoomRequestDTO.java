package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

@Data
public class RoomRequestDTO extends BaseDTO {
        private HotelRequestDTO hotel;
        private int floorNumber;
        private int roomNumber;
}
