package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.PlaneTicketEntity;
import com.allianz.healthtourism.database.repository.PlaneTicketRepository;
import com.allianz.healthtourism.database.specification.PlaneTicketSpecification;
import com.allianz.healthtourism.mapper.PlaneTicketMapper;
import com.allianz.healthtourism.model.requestDTO.PlaneTicketRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneTicketResponseDTO;
import com.allianz.healthtourism.service.PlaneTicketService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("plane-ticket")
@RequiredArgsConstructor
public class PlaneTicketController extends BaseController<PlaneTicketRequestDTO,
        PlaneTicketResponseDTO,
        PlaneTicketEntity,
        PlaneTicketMapper,
        PlaneTicketRepository,
        PlaneTicketSpecification,
        PlaneTicketService> {
    private final PlaneTicketService service;

    @Override
    protected PlaneTicketService getService() {
        return service;
    }
}
