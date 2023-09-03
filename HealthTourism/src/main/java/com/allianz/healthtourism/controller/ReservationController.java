package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.database.repository.ReservationRepository;
import com.allianz.healthtourism.mapper.ReservationMapper;
import com.allianz.healthtourism.model.DTO.ReservationDTO;
import com.allianz.healthtourism.model.requestDTO.ReservationRequestDTO;
import com.allianz.healthtourism.service.ReservationService;
import com.allianz.healthtourism.util.BaseController;

public class ReservationController extends BaseController<ReservationEntity, ReservationDTO, ReservationRequestDTO,
        ReservationMapper, ReservationRepository, ReservationService> {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    protected ReservationService getService() {
        return reservationService;
    }
}
