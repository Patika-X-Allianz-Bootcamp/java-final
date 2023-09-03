package com.demo.medicaltourismapp.service;

import com.demo.medicaltourismapp.database.entity.FlightEntity;
import com.demo.medicaltourismapp.database.repository.FlightRepository;
import com.demo.medicaltourismapp.mapper.FlightMapper;
import com.demo.medicaltourismapp.model.FlightDTO;
import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.model.requestDTO.FlightRequestDTO;
import com.demo.medicaltourismapp.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FlightService extends BaseService<FlightEntity, FlightDTO, FlightRequestDTO,
        FlightMapper, FlightRepository> {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;


    @Override
    protected FlightMapper getMapper() {
        return flightMapper;
    }

    @Override
    protected FlightRepository getRepository() {
        return flightRepository;
    }

    // this ensures that the capacity is not full when listing flights
    public List<FlightDTO> getByFromCityAndToCity(CityEnum fromCity, CityEnum toCity) {
        List<FlightEntity> flightEntityList = flightRepository.getAllByFromCityAndToCityAndCapacityGreaterThan(
                fromCity, toCity, 0);
        return flightMapper.entityListToDtoList(flightEntityList);
    }

    public FlightDTO getByNonZeroCapacityAndUuid(UUID uuid) {
        FlightEntity flightEntity = flightRepository.getAllByCapacityGreaterThanAndUuid(0, uuid);
        return flightMapper.entityToDto(flightEntity);
    }
}
