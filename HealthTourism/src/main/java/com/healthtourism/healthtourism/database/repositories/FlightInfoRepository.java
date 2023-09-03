package com.healthtourism.healthtourism.database.repositories;

import com.healthtourism.healthtourism.database.entities.FlightInfoEntity;
import com.healthtourism.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightInfoRepository extends IBaseRepository <FlightInfoEntity> {
   List<FlightInfoEntity> findByReservationStatusAndCurrentDateTimeBefore(String reservationStatus, LocalDateTime currentDateTime);
}
