package com.tourismcorp.healthtourism.database.repositories;

import com.tourismcorp.healthtourism.database.entities.RoleEntity;
import com.tourismcorp.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends IBaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);
}
