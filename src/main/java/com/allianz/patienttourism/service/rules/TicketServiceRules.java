package com.allianz.patienttourism.service.rules;

import com.allianz.patienttourism.model.responseDTO.BookingResponseDTO;
import com.allianz.patienttourism.model.responseDTO.PatientResponseDTO;
import com.allianz.patienttourism.model.responseDTO.SeatResponseDTO;
import com.allianz.patienttourism.model.responseDTO.TicketResponseDTO;
import com.allianz.patienttourism.service.PatientService;
import com.allianz.patienttourism.service.SeatService;
import com.allianz.patienttourism.util.exceptions.PatientOccupiedException;
import com.allianz.patienttourism.util.exceptions.SeatOccupiedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceRules {

    private final SeatService seatService;
    private final PatientService patientService;

    public void checkIfSeatOccupied(Long seatId, LocalDateTime ticketTime){
        SeatResponseDTO seatResponseDTO = seatService.getByID(seatId);
        List<TicketResponseDTO> ticketResponseDTOList = seatResponseDTO.getTicketList();

        for (TicketResponseDTO ticket:ticketResponseDTOList) {
            if (ticket.getTicketTime().equals(ticketTime)) {
                throw new SeatOccupiedException("This seat is already taken");
            }
        }
    }

    public void checkIfPatientOccupied(Long patientId, LocalDateTime ticketTime){
        PatientResponseDTO patientResponseDTO = patientService.getByID(patientId);
        List<TicketResponseDTO> ticketResponseDTOList = patientResponseDTO.getTicketList();

        for (TicketResponseDTO ticket:ticketResponseDTOList) {
            if (ticket.getTicketTime().equals(ticketTime)) {
                throw new PatientOccupiedException("You have already a ticket for given time");
            }
        }
    }
}
