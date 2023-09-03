package com.allianz.medicaltourism.database.repository;

import com.allianz.medicaltourism.database.entity.RoleEntity;
import com.allianz.medicaltourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
