package com.patika.healthtourism.database.repository;

import com.patika.healthtourism.database.entity.RoleEntity;
import com.patika.healthtourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends IBaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);
}
