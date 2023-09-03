package com.allianz.medicaltourismapp.database.repository;


import com.allianz.medicaltourismapp.database.entity.HospitalEntity;
import com.allianz.medicaltourismapp.database.entity.roles.HospitalSecretaryEntity;
import com.allianz.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalSecretaryEntityRepository extends BaseRepository<HospitalSecretaryEntity> {
    Optional<HospitalSecretaryEntity> findByUsername(String email);
}