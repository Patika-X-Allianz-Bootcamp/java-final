package Tourism.database.repository;

import Tourism.database.entity.AppointmentEntity;
import Tourism.database.entity.DoctorEntity;
import Tourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends BaseRepository<DoctorEntity> {
}
