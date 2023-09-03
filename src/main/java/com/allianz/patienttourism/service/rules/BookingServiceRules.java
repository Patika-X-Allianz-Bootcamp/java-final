package com.allianz.patienttourism.service.rules;

import com.allianz.patienttourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.patienttourism.model.responseDTO.BookingResponseDTO;
import com.allianz.patienttourism.model.responseDTO.PatientResponseDTO;
import com.allianz.patienttourism.model.responseDTO.RoomResponseDTO;
import com.allianz.patienttourism.service.PatientService;
import com.allianz.patienttourism.service.RoomService;
import com.allianz.patienttourism.util.exceptions.PatientOccupiedException;
import com.allianz.patienttourism.util.exceptions.RoomOccupiedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceRules {

    private final RoomService roomService;
    private final PatientService patientService;

    public void checkIfRoomOccupied(Long roomId, LocalDate bookingDate){
        RoomResponseDTO roomResponseDTO = roomService.getByID(roomId);
        List<BookingResponseDTO> bookingResponseDTOList = roomResponseDTO.getBookingList();

        for (BookingResponseDTO booking:bookingResponseDTOList) {
            if (booking.getBookingDate().equals(bookingDate)) {
                throw new RoomOccupiedException("This room is already booked for selected day");
            }
        }
    }

    public void checkIfPatientOccupied(Long patientId, LocalDate bookingDate){
        PatientResponseDTO patientResponseDTO = patientService.getByID(patientId);
        List<BookingResponseDTO> bookingResponseDTOList = patientResponseDTO.getBookingList();
        for (BookingResponseDTO booking:bookingResponseDTOList) {
            if (booking.getBookingDate().equals(bookingDate)) {
                throw new PatientOccupiedException("You have already a booking for selected day");
            }
        }

    }
}
