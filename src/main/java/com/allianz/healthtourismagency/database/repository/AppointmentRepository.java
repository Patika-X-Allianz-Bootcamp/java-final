package com.allianz.healthtourismagency.database.repository;

import com.allianz.healthtourismagency.database.entity.AppointmentEntity;
import com.allianz.healthtourismagency.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends IBaseRepository<AppointmentEntity> {
}
