package patika.fhw.demo.util.dbutil;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean 
public interface BaseRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    Optional<T> findByUuid(UUID uuid);
    
    boolean existsByUuid(String uuid);

    void deleteByUuid(String uuid);
    
    List<T> findAllByCreatedAtBetween(Date startDate, Date endDate);
}
