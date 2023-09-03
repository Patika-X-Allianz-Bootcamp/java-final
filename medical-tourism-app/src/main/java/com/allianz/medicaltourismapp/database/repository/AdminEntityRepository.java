package com.allianz.medicaltourismapp.database.repository;

import com.allianz.medicaltourismapp.database.entity.AppointmentEntity;
import com.allianz.medicaltourismapp.database.entity.roles.AdminEntity;
import com.allianz.medicaltourismapp.database.entity.roles.HospitalSecretaryEntity;
import com.allianz.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminEntityRepository extends BaseRepository<AdminEntity> {
    Optional<AdminEntity> findByEmail(String email);

}
