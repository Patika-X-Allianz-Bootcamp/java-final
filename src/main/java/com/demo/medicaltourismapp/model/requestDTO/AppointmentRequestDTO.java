package com.demo.medicaltourismapp.model.requestDTO;

import com.demo.medicaltourismapp.model.DoctorDTO;
import com.demo.medicaltourismapp.model.FlightDTO;
import com.demo.medicaltourismapp.model.HospitalDTO;
import com.demo.medicaltourismapp.model.HotelDTO;
import com.demo.medicaltourismapp.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AppointmentRequestDTO extends BaseDTO {
    private List<FlightDTO> flights;
    private HotelDTO hotel;
    private DoctorDTO doctor;
    private HospitalDTO hospital;
    private int hotelStayDurationInDays;
    private LocalDate reservationStartDay;
    private String doctorsNotes;
}
