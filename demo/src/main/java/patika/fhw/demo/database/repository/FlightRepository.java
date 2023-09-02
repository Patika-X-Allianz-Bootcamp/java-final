package patika.fhw.demo.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import patika.fhw.demo.database.entity.Flight;
import patika.fhw.demo.util.dbutil.BaseRepository;
@Repository
public interface FlightRepository extends BaseRepository<Flight> {
    List<Flight> findAllByAirline(String airline);
    
}
