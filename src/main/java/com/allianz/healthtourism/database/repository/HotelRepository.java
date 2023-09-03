package com.allianz.healthtourism.database.repository;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends BaseRepository<HotelEntity> {
    List<HotelEntity> findByCityName(String cityName);
}
