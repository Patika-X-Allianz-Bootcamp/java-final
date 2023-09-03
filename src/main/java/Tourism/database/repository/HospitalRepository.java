package Tourism.database.repository;

import Tourism.database.entity.AppointmentEntity;
import Tourism.database.entity.HospitalEntity;
import Tourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends BaseRepository<HospitalEntity> {
}
