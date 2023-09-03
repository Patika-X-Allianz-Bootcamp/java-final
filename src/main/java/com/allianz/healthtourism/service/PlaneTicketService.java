package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.entity.PlaneTicketEntity;
import com.allianz.healthtourism.database.entity.SeatEntity;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.database.repository.PlaneTicketRepository;
import com.allianz.healthtourism.database.repository.SeatRepository;
import com.allianz.healthtourism.database.specification.PlaneTicketSpecification;
import com.allianz.healthtourism.mapper.PlaneTicketMapper;
import com.allianz.healthtourism.model.requestDTO.PlaneTicketRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneTicketResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class PlaneTicketService extends BaseService<PlaneTicketResponseDTO, PlaneTicketRequestDTO, PlaneTicketEntity, PlaneTicketMapper, PlaneTicketRepository, PlaneTicketSpecification> {
    private final PlaneTicketRepository repository;
    private final PlaneTicketSpecification specification;
    private final PatientService patientService;
    private final SeatRepository seatRepository;
    private final FlightRepository flightRepository;

    @Override
    protected PlaneTicketMapper getMapper() {
        return PlaneTicketMapper.INSTANCE;
    }

    @Override
    protected PlaneTicketRepository getRepository() {
        return repository;
    }

    @Override
    protected PlaneTicketSpecification getSpecification() {
        return specification;
    }

    @Override
    public PlaneTicketResponseDTO save(PlaneTicketRequestDTO requestDTO) {
        SeatEntity seat = seatRepository.findById(requestDTO.getSeatId()).orElse(null);

        if (seat != null && seat.isAvailable()) {
            seat.setAvailable(false);
            seatRepository.save(seat);
            PatientEntity patient = patientService.findById(requestDTO.getPatientId());
            FlightEntity flightEntity = flightRepository.findById(requestDTO.getFlightId()).orElse(null);
            if (flightEntity.getPatients() == null) {
                flightEntity.setPatients(new ArrayList<>());
            }
            flightEntity.getPatients().add(patient);
            flightRepository.save(flightEntity);
            return super.save(requestDTO);
        }
        return null;
    }
}
