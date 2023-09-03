package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.AppointmentEntity;
import com.tourismcorp.healthtourism.database.repositories.AppointmentRepository;
import com.tourismcorp.healthtourism.database.specification.AppointmentSpecification;
import com.tourismcorp.healthtourism.mapper.AppointmentMapper;
import com.tourismcorp.healthtourism.model.AppointmentDTO;
import com.tourismcorp.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.tourismcorp.healthtourism.model.requestDTO.SelectHospitalRequestDTO;
import com.tourismcorp.healthtourism.service.AppointmentService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("appointment")
public class AppointmentController extends BaseController<
        AppointmentEntity,
        AppointmentDTO,
        AppointmentRequestDTO,
        AppointmentMapper,
        AppointmentRepository,
        AppointmentSpecification,
        AppointmentService> {

    @Autowired
    AppointmentService appointmentService;

    @Override
    protected AppointmentService getService() {
        return this.appointmentService;
    }

    @PostMapping("/user/{userUUID}/hospital/{hospitalUUID}")
    public AppointmentDTO selectHospital(@PathVariable UUID userUUID, @PathVariable UUID hospitalUUID) {
        return this.appointmentService.selectHospital(userUUID, hospitalUUID);
    }

    @PostMapping("/user/{userUUID}/hotel/{hotelUUID}")
    public AppointmentDTO selectHotel(@PathVariable UUID userUUID, @PathVariable UUID hotelUUID) {
        return this.appointmentService.selectHotel(userUUID, hotelUUID);
    }

    @PostMapping("/user/{userUUID}/doctor/{doctorUUID}")
    public AppointmentDTO selectDoctor(@PathVariable UUID userUUID, @PathVariable UUID doctorUUID) {
        return this.appointmentService.selectDoctor(userUUID, doctorUUID);
    }

    @PostMapping("/user/{userUUID}/room/{roomUUID}")
    public AppointmentDTO selectRoom(@PathVariable UUID userUUID, @PathVariable UUID roomUUID) {
        return this.appointmentService.selectRoom(userUUID, roomUUID);
    }

    @PostMapping("/user/{userUUID}/seat/{seatUUID}")
    public AppointmentDTO selectSeat(@PathVariable UUID userUUID, @PathVariable UUID seatUUID) {
        return this.appointmentService.selectSeat(userUUID, seatUUID);
    }

    @PostMapping("/user/{userUUID}/flight/{flightUUID}")
    public AppointmentDTO selectFlight(@PathVariable UUID userUUID, @PathVariable UUID flightUUID) {
        return this.appointmentService.selectFlight(userUUID, flightUUID);
    }

}
