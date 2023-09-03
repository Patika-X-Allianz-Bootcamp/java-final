package com.patika.healthtourism.database.repository;

import com.patika.healthtourism.database.entity.HealthServiceEntity;
import com.patika.healthtourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthServiceEntityRepository extends IBaseRepository<HealthServiceEntity> {
}
