package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.database.repository.HotelRepository;
import com.allianz.healthtourism.database.specification.HotelSpecification;
import com.allianz.healthtourism.mapper.HotelMapper;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HotelForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HotelResponseDTO;
import com.allianz.healthtourism.service.HotelService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("hotel")
@RequiredArgsConstructor
public class HotelController extends BaseController<HotelRequestDTO, HotelResponseDTO, HotelEntity, HotelMapper, HotelRepository, HotelSpecification, HotelService> {
    private final HotelService service;

    @Override
    protected HotelService getService() {
        return service;
    }


    @GetMapping("city/{cityName}")
    public ResponseEntity<List<HotelForPatientResponseDTO>> getByUuid(@PathVariable String cityName) {
        try {
           List<HotelForPatientResponseDTO> responseDTOs = getService().findByCityName(cityName);
            return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
