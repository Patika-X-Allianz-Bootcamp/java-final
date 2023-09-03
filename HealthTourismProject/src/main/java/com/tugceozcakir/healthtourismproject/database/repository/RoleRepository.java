package com.tugceozcakir.healthtourismproject.database.repository;

import com.tugceozcakir.healthtourismproject.database.entity.RoleEntity;
import com.tugceozcakir.healthtourismproject.util.dbUtil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);
}