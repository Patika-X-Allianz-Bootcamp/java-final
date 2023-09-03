package com.demo.medicaltourismapp.database.repository;

import com.demo.medicaltourismapp.database.entity.UserEntity;
import com.demo.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
    Optional<UserEntity> findByEmail(String email);
}
