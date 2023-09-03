package com.allianz.healthtourism.database.repository;

import com.allianz.healthtourism.database.entity.AdminEntity;
import com.allianz.healthtourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends BaseRepository<AdminEntity> {

    Optional<AdminEntity> findByEmail(String email);
}
