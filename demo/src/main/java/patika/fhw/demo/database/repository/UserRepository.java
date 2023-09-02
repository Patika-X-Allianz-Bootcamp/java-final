package patika.fhw.demo.database.repository;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import patika.fhw.demo.database.entity.UserEntity;
import patika.fhw.demo.util.dbutil.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}

