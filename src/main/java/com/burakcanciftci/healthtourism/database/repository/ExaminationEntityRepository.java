package com.burakcanciftci.healthtourism.database.repository;

import com.burakcanciftci.healthtourism.database.entity.ExaminationEntity;
import com.burakcanciftci.healthtourism.database.entity.SeatReservationEntity;
import com.burakcanciftci.healthtourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExaminationEntityRepository extends IBaseRepository<ExaminationEntity> {
    Optional<ExaminationEntity> findByCode(String code);
}
