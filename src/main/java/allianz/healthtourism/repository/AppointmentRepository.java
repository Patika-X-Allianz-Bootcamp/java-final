package allianz.healthtourism.repository;

import allianz.healthtourism.base.BaseRepository;
import allianz.healthtourism.entity.Appointment;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment> {

    Optional<Appointment> findByDoctorUuidAndPatientUuid(UUID doctorUuid, UUID patientUuid);

}
