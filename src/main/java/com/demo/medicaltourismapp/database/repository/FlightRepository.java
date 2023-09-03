package com.demo.medicaltourismapp.database.repository;

import com.demo.medicaltourismapp.database.entity.FlightEntity;
import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FlightRepository extends BaseRepository<FlightEntity> {

    List<FlightEntity> getAllByFromCityAndToCityAndCapacityGreaterThan(CityEnum fromCity, CityEnum toCity,
                                                                       int capacity);

    FlightEntity getAllByCapacityGreaterThanAndUuid(int capacity, UUID uuid);
}
