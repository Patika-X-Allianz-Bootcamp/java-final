package patika.fhw.demo.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import patika.fhw.demo.database.entity.Appointment;
import patika.fhw.demo.util.dbutil.BaseRepository;
@Repository
public interface AppointmentRepository extends BaseRepository<Appointment> {
    List<Appointment> findAllByDoctorId(Long doctorId);
    
}
