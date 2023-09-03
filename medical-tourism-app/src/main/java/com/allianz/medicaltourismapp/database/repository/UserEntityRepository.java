package com.allianz.medicaltourismapp.database.repository;


import com.allianz.medicaltourismapp.database.entity.roles.UserEntity;
import com.allianz.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends BaseRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}