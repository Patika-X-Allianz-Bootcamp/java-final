package com.demo.medicaltourismapp.controller;

import com.demo.medicaltourismapp.database.entity.FlightEntity;
import com.demo.medicaltourismapp.database.repository.FlightRepository;
import com.demo.medicaltourismapp.mapper.FlightMapper;
import com.demo.medicaltourismapp.model.FlightDTO;
import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.model.requestDTO.FlightRequestDTO;
import com.demo.medicaltourismapp.service.FlightService;
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
@RequestMapping("flight")
public class FlightController extends BaseController<FlightEntity, FlightDTO, FlightRequestDTO,
        FlightMapper, FlightRepository, FlightService> {
    private final FlightService flightService;

    @Override
    protected FlightService getService() {
        return flightService;
    }


    @GetMapping("get-by-from-city-and-to-city/{fromCity}/{toCity}")
    public ResponseEntity<List<FlightDTO>> getByFromCityAndToCity(@PathVariable CityEnum fromCity,
                                                                  @PathVariable CityEnum toCity) {
        List<FlightDTO> flightDTOList = flightService.getByFromCityAndToCity(fromCity, toCity);
        if (flightDTOList == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(flightDTOList, HttpStatus.OK);
        }
    }
}
