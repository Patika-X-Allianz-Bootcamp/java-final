package com.allianz.healthtourism.util.security;

import com.allianz.healthtourism.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
