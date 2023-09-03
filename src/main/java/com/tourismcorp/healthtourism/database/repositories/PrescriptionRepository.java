package com.tourismcorp.healthtourism.database.repositories;

import com.tourismcorp.healthtourism.database.entities.PrescriptionEntity;
import com.tourismcorp.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends IBaseRepository<PrescriptionEntity> {
}
