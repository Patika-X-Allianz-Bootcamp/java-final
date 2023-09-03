package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.TicketEntity;
import com.allianz.medicaltourismapp.database.repository.TicketEntityRepository;
import com.allianz.medicaltourismapp.database.specification.TicketSpecification;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.mapper.TicketMapper;
import com.allianz.medicaltourismapp.model.TicketDTO;
import com.allianz.medicaltourismapp.service.TicketService;
import com.allianz.medicaltourismapp.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("ticketz")
@RequiredArgsConstructor
public class TicketController extends BaseController<

        TicketEntity,
        TicketDTO,
        TicketMapper,
        TicketEntityRepository,
        TicketSpecification, TicketService
        > {

    @Autowired
    TicketMapper ticketMapper;
    @Override
    protected TicketMapper getMapper() {
        return ticketMapper;
    }

    @Autowired
    TicketService ticketService;
    @Override
    protected TicketService getService() {
        return ticketService;
    }
}