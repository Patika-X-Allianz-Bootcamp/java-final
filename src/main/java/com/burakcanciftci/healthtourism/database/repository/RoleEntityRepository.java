package com.burakcanciftci.healthtourism.database.repository;

import com.burakcanciftci.healthtourism.database.entity.RoleEntity;
import com.burakcanciftci.healthtourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends IBaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);
}
