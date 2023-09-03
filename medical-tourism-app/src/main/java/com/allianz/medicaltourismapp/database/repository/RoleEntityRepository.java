package com.allianz.medicaltourismapp.database.repository;


import com.allianz.medicaltourismapp.database.entity.RoleEntity;
import com.allianz.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);
}