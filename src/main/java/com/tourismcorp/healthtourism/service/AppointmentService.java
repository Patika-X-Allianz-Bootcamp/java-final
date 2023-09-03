package com.tourismcorp.healthtourism.service;

import com.tourismcorp.healthtourism.database.entities.*;
import com.tourismcorp.healthtourism.database.repositories.AppointmentRepository;
import com.tourismcorp.healthtourism.database.specification.AppointmentSpecification;
import com.tourismcorp.healthtourism.exceptions.EntityNotFoundByUUID;
import com.tourismcorp.healthtourism.mapper.AppointmentMapper;
import com.tourismcorp.healthtourism.model.AppointmentDTO;
import com.tourismcorp.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.tourismcorp.healthtourism.model.requestDTO.SelectHospitalRequestDTO;
import com.tourismcorp.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AppointmentService extends BaseService<
        AppointmentEntity,
        AppointmentDTO,
        AppointmentRequestDTO,
        AppointmentMapper,
        AppointmentRepository,
        AppointmentSpecification> {


    private final AppointmentRepository appointmentRepository;

    private final AppointmentMapper appointmentMapper;

    private final AppointmentSpecification appointmentSpecification;

    private final UserService userService;

    private final HospitalService hospitalService;

    private final HotelService hotelService;

    private final DoctorService doctorService;

    private final RoomService roomService;

    private final SeatService seatService;

    private final FlightService flightService;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper,
                              AppointmentSpecification appointmentSpecification, UserService userService,
                              HospitalService hospitalService, HotelService hotelService, DoctorService doctorService,
                              RoomService roomService, SeatService seatService, FlightService flightService) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.appointmentSpecification = appointmentSpecification;
        this.userService = userService;
        this.hospitalService = hospitalService;
        this.hotelService = hotelService;
        this.doctorService = doctorService;
        this.roomService = roomService;
        this.seatService = seatService;
        this.flightService = flightService;
    }


    @Override
    protected AppointmentMapper getMapper() {
        return this.appointmentMapper;
    }

    @Override
    protected AppointmentRepository getRepository() {
        return this.appointmentRepository;
    }

    @Override
    protected AppointmentSpecification getSpecification() {
        return this.appointmentSpecification;
    }

    public AppointmentDTO selectHospital(UUID userUUID,UUID hospitalUUID) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        HospitalEntity hospitalEntity = hospitalService.getRepository().findByUuid(hospitalUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        UserEntity userEntity = userService.getRepository().findByUuid(userUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        appointmentEntity.setHospital(hospitalEntity);
        appointmentEntity.setUser(userEntity);

        return this.getMapper().entityToDTO(this.getRepository().save(appointmentEntity));
    }

    public AppointmentDTO selectDoctor(UUID appointmentUUID, UUID doctorUUID) {
        AppointmentEntity appointmentEntity = this.getRepository().findByUuid(appointmentUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        DoctorEntity doctorEntity = doctorService.getRepository().findByUuid(doctorUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        appointmentEntity.setDoctor(doctorEntity);

        return this.getMapper().entityToDTO(this.getRepository().save(appointmentEntity));
    }

    public AppointmentDTO selectDate(UUID appointmentUUID, Date date) {
        AppointmentEntity appointmentEntity = this.getRepository().findByUuid(appointmentUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        appointmentEntity.setDate(date);

        return this.getMapper().entityToDTO(this.getRepository().save(appointmentEntity));
    }

    public AppointmentDTO selectHotel(UUID appointmentUUID, UUID hotelUUID) {
        AppointmentEntity appointmentEntity = this.getRepository().findByUuid(appointmentUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        HotelEntity hotelEntity = hotelService.getRepository().findByUuid(hotelUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        appointmentEntity.setHotel(hotelEntity);

        return this.getMapper().entityToDTO(this.getRepository().save(appointmentEntity));
    }

    public AppointmentDTO selectRoom(UUID appointmentUUID, UUID roomUUID) {
        AppointmentEntity appointmentEntity = this.getRepository().findByUuid(appointmentUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        RoomEntity roomEntity = roomService.getRepository().findByUuid(roomUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        appointmentEntity.setRoom(roomEntity);

        return this.getMapper().entityToDTO(this.getRepository().save(appointmentEntity));
    }

    public AppointmentDTO selectFlight(UUID appointmentUUID, UUID flightUUID) {
        AppointmentEntity appointmentEntity = this.getRepository().findByUuid(appointmentUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        FlightEntity flightEntity = flightService.getRepository().findByUuid(flightUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        appointmentEntity.setFlight(flightEntity);

        return this.getMapper().entityToDTO(this.getRepository().save(appointmentEntity));
    }

    public AppointmentDTO selectSeat(UUID appointmentUUID, UUID seatUUID) {
        AppointmentEntity appointmentEntity = this.getRepository().findByUuid(appointmentUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        SeatEntity seatEntity = seatService.getRepository().findByUuid(seatUUID)
                .orElseThrow(EntityNotFoundByUUID::new);
        appointmentEntity.setSeat(seatEntity);

        return this.getMapper().entityToDTO(this.getRepository().save(appointmentEntity));
    }
}
