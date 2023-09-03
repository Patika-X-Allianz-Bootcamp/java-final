package com.burakcanciftci.healthtourism.database.repository;

import com.burakcanciftci.healthtourism.database.entity.SeatReservationEntity;
import com.burakcanciftci.healthtourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatReservationEntityRepository extends IBaseRepository<SeatReservationEntity> {
    Optional<SeatReservationEntity> findByCode(String code);
}
