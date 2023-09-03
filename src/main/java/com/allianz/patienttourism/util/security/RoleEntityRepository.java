package com.allianz.patienttourism.util.security;

import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends IBaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
