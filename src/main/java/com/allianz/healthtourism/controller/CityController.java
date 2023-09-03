package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.BookingEntity;
import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.repository.BookingRepository;
import com.allianz.healthtourism.database.repository.CityRepository;
import com.allianz.healthtourism.database.specification.BookingSpecification;
import com.allianz.healthtourism.database.specification.CitySpecification;
import com.allianz.healthtourism.mapper.BookingMapper;
import com.allianz.healthtourism.mapper.CityMapper;
import com.allianz.healthtourism.model.requestDTO.BookingRequestDTO;
import com.allianz.healthtourism.model.requestDTO.CityRequestDTO;
import com.allianz.healthtourism.model.responseDTO.BookingResponseDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.service.BookingService;
import com.allianz.healthtourism.service.CityService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("city")
@RequiredArgsConstructor
public class CityController extends BaseController<CityRequestDTO,
        CityResponseDTO,
        CityEntity,
        CityMapper,
        CityRepository,
        CitySpecification,
        CityService> {
    private final CityService service;

    @Override
    protected CityService getService() {
        return service;
    }
}
