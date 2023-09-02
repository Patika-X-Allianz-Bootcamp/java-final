package patika.fhw.demo.database.repository;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import patika.fhw.demo.database.entity.RoleEntity;
import patika.fhw.demo.util.dbutil.BaseRepository;

@Repository
public interface RoleRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
