package patika.fhw.demo.database.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import patika.fhw.demo.database.entity.Patient;
import patika.fhw.demo.util.dbutil.BaseRepository;
@Repository
public interface PatientRepository extends BaseRepository<Patient> {
    Optional<Patient> findByEmail(String email);
}
