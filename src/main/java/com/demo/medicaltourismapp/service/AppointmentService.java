package com.demo.medicaltourismapp.service;

import com.demo.medicaltourismapp.database.entity.AppointmentEntity;
import com.demo.medicaltourismapp.database.repository.AppointmentRepository;
import com.demo.medicaltourismapp.mapper.AppointmentMapper;
import com.demo.medicaltourismapp.model.*;
import com.demo.medicaltourismapp.model.requestDTO.AppointmentRequestDTO;
import com.demo.medicaltourismapp.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppointmentService extends BaseService<AppointmentEntity, AppointmentDTO, AppointmentRequestDTO,
        AppointmentMapper, AppointmentRepository> {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    // these services are required to make reservations for hotel, hospital and planes
    // mappers can be reached by service.getMapper() method
    private final HotelService hotelService;
    private final FlightService flightService;
    private final HospitalService hospitalService;

    @Override
    protected AppointmentMapper getMapper() {
        return appointmentMapper;
    }

    @Override
    protected AppointmentRepository getRepository() {
        return appointmentRepository;
    }

    public AppointmentDTO createNewAppointment(){
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        return new AppointmentDTO();
    }
    public AppointmentDTO reserveHotelByUuid(UUID uuid, UUID appointmentUuid) {
        AppointmentDTO appointmentDTO = this.getByUUID(appointmentUuid);
        // here capacity is automatically checked
        HotelDTO hotelDTO = hotelService.getByNonZeroCapacityAndUuid(uuid);

        if (appointmentDTO == null || hotelDTO == null) {
            return null;
        } else {
            appointmentDTO.setHotel(hotelDTO);
            return appointmentDTO;
        }
    }

    public AppointmentDTO reserveHospitalByUuid(UUID uuid, UUID appointmentUuid) {
        AppointmentDTO appointmentDTO = this.getByUUID(appointmentUuid);
        HospitalDTO hospitalDTO = hospitalService.getByUUID(uuid); // there is no capacity field for hospitals yet

        if (appointmentDTO == null || hospitalDTO == null) {
            return null;
        } else {
            appointmentDTO.setHospital(hospitalDTO);
            return appointmentDTO;
        }
    }

    public AppointmentDTO reserveFlightByUuid(UUID uuid, UUID appointmenUuid) {
        AppointmentDTO appointmentDTO = this.getByUUID(appointmenUuid);
        // capacity check
        FlightDTO flightDTO = flightService.getByNonZeroCapacityAndUuid(uuid);
        if (appointmentDTO == null || flightDTO == null) {
            return null;
        } else if (appointmentDTO.getFlights() == null) {
            List<FlightDTO> flightDTOList = new ArrayList<>();
            flightDTOList.add(flightDTO);
            appointmentDTO.setFlights(flightDTOList);
        } else {
            List<FlightDTO> flightDTOList = appointmentDTO.getFlights();
            flightDTOList.add(flightDTO);
            appointmentDTO.setFlights(flightDTOList);
        }
        return appointmentDTO;
    }
}
