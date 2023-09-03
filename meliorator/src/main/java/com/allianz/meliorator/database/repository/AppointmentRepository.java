package com.allianz.meliorator.database.repository;
import com.allianz.meliorator.database.entity.Appointment;
import com.allianz.meliorator.util_db.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends IBaseRepository<Appointment> {
}
