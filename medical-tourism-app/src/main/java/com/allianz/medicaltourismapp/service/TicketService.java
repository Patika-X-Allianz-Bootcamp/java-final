package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.TicketEntity;
import com.allianz.medicaltourismapp.database.repository.TicketEntityRepository;
import com.allianz.medicaltourismapp.database.repository.TicketEntityRepository;

import com.allianz.medicaltourismapp.database.specification.TicketSpecification;
import com.allianz.medicaltourismapp.database.specification.TicketSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.TicketMapper;
import com.allianz.medicaltourismapp.mapper.TicketMapper;

import com.allianz.medicaltourismapp.model.TicketDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TicketService extends BaseService<
        TicketDTO,
        TicketEntity,
        TicketEntityRepository,
        TicketMapper,
        TicketSpecification> {

    private final TicketEntityRepository ticketEntityRepository;
    private final TicketMapper mapper;



    private final TicketSpecification ticketSpecification;

    @Override
    protected TicketMapper getMapper() {
        return mapper;    }

    @Override
    protected TicketEntityRepository getRepository() {
        return ticketEntityRepository;
    }

    @Override
    protected TicketSpecification getSpecification() {
        return ticketSpecification;
    }
}