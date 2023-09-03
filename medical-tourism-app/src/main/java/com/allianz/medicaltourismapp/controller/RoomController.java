package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.RoomEntity;
import com.allianz.medicaltourismapp.database.repository.RoomEntityRepository;
import com.allianz.medicaltourismapp.database.specification.RoomSpecification;
import com.allianz.medicaltourismapp.mapper.ReservationMapper;
import com.allianz.medicaltourismapp.mapper.RoomMapper;
import com.allianz.medicaltourismapp.model.RoomDTO;
import com.allianz.medicaltourismapp.service.RoomService;

import com.allianz.medicaltourismapp.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
@RequiredArgsConstructor
public class RoomController extends BaseController<

        RoomEntity,
        RoomDTO,
        RoomMapper,
        RoomEntityRepository,
        RoomSpecification, RoomService
        > {

    @Autowired
    RoomMapper roomMapper;

    @Override
    protected RoomMapper getMapper() {
        return roomMapper;
    }
    @Autowired
    RoomService roomService;
    @Override
    protected RoomService getService() {
        return roomService;
    }
}