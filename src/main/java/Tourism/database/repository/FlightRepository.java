package Tourism.database.repository;

import Tourism.database.entity.AppointmentEntity;
import Tourism.database.entity.FlightEntity;
import Tourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends BaseRepository<FlightEntity> {
}
