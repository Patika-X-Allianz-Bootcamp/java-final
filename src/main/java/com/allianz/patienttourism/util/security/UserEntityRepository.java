package com.allianz.patienttourism.util.security;


import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends IBaseRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}
