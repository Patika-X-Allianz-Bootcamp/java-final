package com.patika.healthtourism.database.repository;

import com.patika.healthtourism.database.entity.FlightEntity;
import com.patika.healthtourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightEntityRepository extends IBaseRepository<FlightEntity> {

    Optional<List<FlightEntity>> findByArrivalDateTimeBefore(LocalDateTime dateTime);
}
