package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.SeatEntity;
import com.allianz.healthtourism.database.repository.SeatRepository;
import com.allianz.healthtourism.database.specification.SeatSpecification;
import com.allianz.healthtourism.mapper.SeatMapper;
import com.allianz.healthtourism.model.requestDTO.SeatRequestDTO;
import com.allianz.healthtourism.model.responseDTO.SeatResponseDTO;
import com.allianz.healthtourism.service.SeatService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seat")
@RequiredArgsConstructor
public class SeatController extends BaseController<SeatRequestDTO, SeatResponseDTO, SeatEntity, SeatMapper, SeatRepository, SeatSpecification, SeatService> {
    private final SeatService service;

    @Override
    protected SeatService getService() {
        return service;
    }
}
