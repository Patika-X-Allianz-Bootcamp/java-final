package com.healthtourism.healthtourism.database.repositories;

import com.healthtourism.healthtourism.database.entities.DoctorEntity;
import com.healthtourism.healthtourism.database.entities.SpecializationEnum;
import com.healthtourism.healthtourism.util.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends IBaseRepository <DoctorEntity> {

    List<DoctorEntity> findBySpecialization(SpecializationEnum specialization);

}
