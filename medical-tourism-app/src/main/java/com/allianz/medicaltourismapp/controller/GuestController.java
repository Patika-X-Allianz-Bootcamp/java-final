package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.GuestEntity;
import com.allianz.medicaltourismapp.database.repository.GuestEntityRepository;
import com.allianz.medicaltourismapp.database.specification.GuestSpecification;
import com.allianz.medicaltourismapp.mapper.GuestMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.GuestDTO;
import com.allianz.medicaltourismapp.service.GuestService;
import com.allianz.medicaltourismapp.util.BaseController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("guest")
@RequiredArgsConstructor
public class GuestController extends BaseController<

        GuestEntity,
        GuestDTO,
        GuestMapper,
        GuestEntityRepository,
        GuestSpecification, GuestService
        > {

    @Autowired
    GuestMapper guestMapper;

    @Override
    protected GuestMapper getMapper() {
        return guestMapper;
    }
    @Autowired
    GuestService guestService;
    @Override
    protected GuestService getService() {
        return guestService;
    }
}