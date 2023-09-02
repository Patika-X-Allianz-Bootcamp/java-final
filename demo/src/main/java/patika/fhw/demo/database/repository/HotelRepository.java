package patika.fhw.demo.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import patika.fhw.demo.database.entity.Hotel;
import patika.fhw.demo.util.dbutil.BaseRepository;
@Repository
public interface HotelRepository extends BaseRepository<Hotel> {
    List<Hotel> findAllByStarRating(int starRating);
    
}
