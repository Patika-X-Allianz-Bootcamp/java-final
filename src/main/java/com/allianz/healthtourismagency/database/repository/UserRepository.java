package com.allianz.healthtourismagency.database.repository;

import com.allianz.healthtourismagency.database.entity.UserEntity;
import com.allianz.healthtourismagency.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends IBaseRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}
