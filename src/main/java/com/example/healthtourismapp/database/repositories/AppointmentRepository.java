package com.example.healthtourismapp.database.repositories;

import com.example.healthtourismapp.database.entities.AppointmentEntity;
import com.example.healthtourismapp.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends IBaseRepository<AppointmentEntity> {
}
