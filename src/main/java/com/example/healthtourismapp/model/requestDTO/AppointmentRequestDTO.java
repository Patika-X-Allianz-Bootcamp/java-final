package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.model.FlightDTO;
import com.example.healthtourismapp.model.HospitalDTO;
import com.example.healthtourismapp.model.HotelDTO;
import com.example.healthtourismapp.model.PatientDTO;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO extends BaseDTO {

    private LocalDateTime date;
    private PatientDTO patient;
    private HotelDTO hotel;
    private FlightDTO flight;
    private HospitalDTO hospital;
    private double totalBill;
}
