package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.PassengerEntity;
import com.allianz.medicaltourismapp.database.repository.PassengerEntityRepository;
import com.allianz.medicaltourismapp.database.specification.PassengerSpecification;
import com.allianz.medicaltourismapp.mapper.PassengerMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.PassengerDTO;
import com.allianz.medicaltourismapp.service.PassengerService;

import com.allianz.medicaltourismapp.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("passenger")
@RequiredArgsConstructor
public class PassengerController extends BaseController<

        PassengerEntity,
        PassengerDTO,
        PassengerMapper,
        PassengerEntityRepository,
        PassengerSpecification, PassengerService
        > {
    @Autowired
    PassengerMapper passengerMapper;
    @Override
    protected PassengerMapper getMapper() {
        return passengerMapper;
    }

    @Autowired
    PassengerService passengerService;
    @Override
    protected PassengerService getService() {
        return passengerService;
    }
}