package com.healthtourism.healthtourism.database.repositories;

import com.healthtourism.healthtourism.database.entities.AppointmentEntity;
import com.healthtourism.healthtourism.database.entities.DoctorEntity;
import com.healthtourism.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends IBaseRepository <AppointmentEntity> {
    List<AppointmentEntity> findByStatus(String status);
    boolean existsByDoctorAndAppointmentDateAndAppointmentTime(DoctorEntity doctor, LocalDate appointmentDate, String appointmentTime);
}
