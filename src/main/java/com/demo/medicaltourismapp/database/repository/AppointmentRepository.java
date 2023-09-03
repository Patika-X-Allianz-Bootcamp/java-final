package com.demo.medicaltourismapp.database.repository;

import com.demo.medicaltourismapp.database.entity.AppointmentEntity;
import com.demo.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends BaseRepository<AppointmentEntity> {
}
