package com.allianz.medicaltourism.database.repository;

import com.allianz.medicaltourism.database.entity.DepartmentEntity;
import com.allianz.medicaltourism.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentEntityRepository extends BaseRepository<DepartmentEntity> {
	Optional<DepartmentEntity> findByName(String name);

}
