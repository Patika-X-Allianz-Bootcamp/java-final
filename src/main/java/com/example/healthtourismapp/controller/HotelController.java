package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.HotelEntity;
import com.example.healthtourismapp.database.entities.HotelRoomEntity;
import com.example.healthtourismapp.database.repositories.HotelRepository;
import com.example.healthtourismapp.database.specification.HotelSpecification;
import com.example.healthtourismapp.mapper.HotelMapper;
import com.example.healthtourismapp.model.HotelDTO;
import com.example.healthtourismapp.model.requestDTO.HotelRequestDTO;
import com.example.healthtourismapp.service.HotelService;
import com.example.healthtourismapp.util.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController extends BaseController<HotelEntity, HotelDTO, HotelRequestDTO,
        HotelMapper, HotelRepository, HotelSpecification, HotelService> {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    protected HotelService getService() {
        return hotelService;
    }

    @GetMapping("/{hotelUuid}/room/{roomUuid}")
    public ResponseEntity<HotelRoomEntity> getHotelRoomByUuid(@PathVariable UUID hotelUuid, @PathVariable UUID roomUuid) {
        Optional<HotelRoomEntity> roomOptional = hotelService.selectHotelRoomByUuid(hotelUuid, roomUuid);
        if (roomOptional.isPresent()) {
            return new ResponseEntity<>(roomOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
