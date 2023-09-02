package patika.fhw.demo.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import patika.fhw.demo.database.entity.Hospital;
import patika.fhw.demo.util.dbutil.BaseRepository;
@Repository
public interface HospitalRepository extends BaseRepository<Hospital> {
    List<Hospital> findAllByLocation(String location);
    
}
