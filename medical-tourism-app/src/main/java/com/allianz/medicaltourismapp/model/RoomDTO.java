package com.allianz.medicaltourismapp.model;

import com.allianz.medicaltourismapp.model.enums.BookingStatusEnum;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;

import lombok.Data;

@Data
public class RoomDTO extends BaseDTO {
        private int roomNumber;
        private BookingStatusEnum bookingStatusEnum;
        private HotelDTO hotelDTO;

}
