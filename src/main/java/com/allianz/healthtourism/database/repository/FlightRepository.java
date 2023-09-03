package com.allianz.healthtourism.database.repository;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends BaseRepository<FlightEntity> {
    List<FlightEntity> findByCityFromNameAndAndCityToName(String cityFromName, String cityToName);
}
