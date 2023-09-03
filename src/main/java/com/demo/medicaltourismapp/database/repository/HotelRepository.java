package com.demo.medicaltourismapp.database.repository;

import com.demo.medicaltourismapp.database.entity.HotelEntity;
import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HotelRepository extends BaseRepository<HotelEntity> {

    // we will filter by city and capacity greater than zero by putting capacity = 0
    List<HotelEntity> findByCityAndCapacityGreaterThan(CityEnum cityEnum, int capacity);

    HotelEntity getAllByCapacityGreaterThanAndUuid(int capacity, UUID uuid);
}
