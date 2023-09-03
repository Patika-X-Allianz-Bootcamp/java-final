package com.demo.medicaltourismapp.controller;

import com.demo.medicaltourismapp.database.entity.HotelEntity;
import com.demo.medicaltourismapp.database.repository.HotelRepository;
import com.demo.medicaltourismapp.mapper.HotelMapper;
import com.demo.medicaltourismapp.model.HotelDTO;
import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.model.requestDTO.HotelRequestDTO;
import com.demo.medicaltourismapp.service.HotelService;
import com.demo.medicaltourismapp.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<HotelEntity, HotelDTO, HotelRequestDTO,
        HotelMapper, HotelRepository, HotelService> {

    private final HotelService hotelService;

    @Override
    protected HotelService getService() {
        return hotelService;
    }

    @GetMapping("get-by-city/{city}")
    public ResponseEntity<List<HotelDTO>> getByCity(@PathVariable CityEnum city) {
        List<HotelDTO> hotelDTOList = hotelService.getByCity(city);
        if (hotelDTOList == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(hotelDTOList, HttpStatus.OK);
        }
    }
}
