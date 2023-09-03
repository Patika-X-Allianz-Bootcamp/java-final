package com.tourismcorp.healthtourism.database.repositories;

import com.tourismcorp.healthtourism.database.entities.AppointmentEntity;
import com.tourismcorp.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends IBaseRepository<AppointmentEntity> {
}
