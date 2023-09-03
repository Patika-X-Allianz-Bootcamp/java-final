package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.model.*;
import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data

public class AppointmentRequestDTO extends BaseDTO {
    private DoctorRequestDTO doctor;
    private UserRequestDTO user;
    private Date date;
    private HotelRequestDTO hotel;
    private RoomRequestDTO room;
    private HospitalRequestDTO hospital;
    private FlightRequestDTO flight;
    private SeatRequestDTO seat;

}
