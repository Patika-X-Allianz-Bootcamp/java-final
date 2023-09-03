package com.allianz.patienttourism.model.responseDTO;

import com.allianz.patienttourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class PatientResponseDTO extends BaseResponseDTO {

    private String name;

    private String surname;

    private int age;

    List<AppointmentResponseDTO> appointmentList;

    List<BookingResponseDTO> bookingList;

    List<TicketResponseDTO> ticketList;


}
