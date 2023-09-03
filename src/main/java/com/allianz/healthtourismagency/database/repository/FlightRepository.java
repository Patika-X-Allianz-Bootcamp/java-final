package com.allianz.healthtourismagency.database.repository;

import com.allianz.healthtourismagency.database.entity.FlightEntity;
import com.allianz.healthtourismagency.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends IBaseRepository<FlightEntity> {
}
