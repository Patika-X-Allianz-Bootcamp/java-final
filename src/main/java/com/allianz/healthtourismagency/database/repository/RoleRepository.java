package com.allianz.healthtourismagency.database.repository;

import com.allianz.healthtourismagency.database.entity.RoleEntity;
import com.allianz.healthtourismagency.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends IBaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
