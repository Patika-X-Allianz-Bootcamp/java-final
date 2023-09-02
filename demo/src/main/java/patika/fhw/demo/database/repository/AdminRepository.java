package patika.fhw.demo.database.repository;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import patika.fhw.demo.database.entity.AdminEntity;
import patika.fhw.demo.util.dbutil.BaseRepository;

@Repository
public interface AdminRepository extends BaseRepository<AdminEntity> {

    Optional<AdminEntity> findByEmail(String email);
}

