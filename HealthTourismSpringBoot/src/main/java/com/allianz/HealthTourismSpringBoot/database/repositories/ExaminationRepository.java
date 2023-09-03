package com.allianz.HealthTourismSpringBoot.database.repositories;

import com.allianz.HealthTourismSpringBoot.database.entities.ExaminationEntity;
import com.allianz.HealthTourismSpringBoot.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends IBaseRepository<ExaminationEntity> {
}
