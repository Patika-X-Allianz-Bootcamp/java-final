package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.ReservationEntity;
import com.allianz.medicaltourismapp.database.repository.ReservationEntityRepository;
import com.allianz.medicaltourismapp.database.specification.ReservationSpecification;
import com.allianz.medicaltourismapp.mapper.ReservationMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.ReservationDTO;
import com.allianz.medicaltourismapp.service.ReservationService;
import com.allianz.medicaltourismapp.util.BaseController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController extends BaseController<

        ReservationEntity,ReservationDTO,

        ReservationMapper,
        ReservationEntityRepository,
        ReservationSpecification, ReservationService
        > {
    @Autowired
    ReservationMapper reservationMapper;

    @Override
    protected ReservationMapper getMapper() {
        return reservationMapper;
    }
    @Autowired
    ReservationService reservationService;
    @Override
    protected ReservationService getService() {
        return reservationService;
    }
}