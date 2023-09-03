package com.burakcanciftci.healthtourism.database.repository;

import com.burakcanciftci.healthtourism.database.entity.UserEntity;
import com.burakcanciftci.healthtourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends IBaseRepository<UserEntity> {
    Optional<UserEntity> findByEmail(String email);
}
