package Tourism.database.repository;

import Tourism.database.entity.AppointmentEntity;
import Tourism.database.entity.HotelEntity;
import Tourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends BaseRepository<HotelEntity> {
}
