package com.patika.healthtourism.database.repository;

import com.patika.healthtourism.database.entity.HotelEntity;
import com.patika.healthtourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface HotelEntityRepository extends IBaseRepository<HotelEntity> {

    Optional<List<HotelEntity>> findByCheckInDateBefore(LocalDate localDate);
}
