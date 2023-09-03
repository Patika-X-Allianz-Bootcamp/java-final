package com.allianz.medicaltourism.database.repository;

import com.allianz.medicaltourism.database.entity.UserEntity;
import com.allianz.medicaltourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends BaseRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}
