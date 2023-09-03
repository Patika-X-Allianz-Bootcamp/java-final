package Tourism.database.repository;

import Tourism.database.entity.AppointmentEntity;
import Tourism.database.entity.PatientEntity;
import Tourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends BaseRepository<PatientEntity> {
}
