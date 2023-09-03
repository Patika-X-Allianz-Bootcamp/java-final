package com.allianz.HealthTourismSpringBoot.database.repositories;

import com.allianz.HealthTourismSpringBoot.database.entities.HospitalEntity;
import com.allianz.HealthTourismSpringBoot.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends IBaseRepository<HospitalEntity> {
}
