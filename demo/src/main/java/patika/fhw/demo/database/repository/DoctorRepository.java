package patika.fhw.demo.database.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import patika.fhw.demo.database.entity.Doctor;
import patika.fhw.demo.util.dbutil.BaseRepository;

@Repository
public interface DoctorRepository extends BaseRepository<Doctor> {
    Optional<Doctor> findByEmail(String email);
    
}
