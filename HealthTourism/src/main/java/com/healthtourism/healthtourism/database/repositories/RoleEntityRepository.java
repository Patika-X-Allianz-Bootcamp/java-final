package com.healthtourism.healthtourism.database.repositories;

import com.healthtourism.healthtourism.database.entities.RoleEntity;
import com.healthtourism.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleEntityRepository extends IBaseRepository<RoleEntity>{
    Optional<RoleEntity> findByName(String name);
}
