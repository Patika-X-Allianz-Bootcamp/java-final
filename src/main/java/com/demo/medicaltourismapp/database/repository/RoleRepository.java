package com.demo.medicaltourismapp.database.repository;

import com.demo.medicaltourismapp.database.entity.RoleEntity;
import com.demo.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);
}
