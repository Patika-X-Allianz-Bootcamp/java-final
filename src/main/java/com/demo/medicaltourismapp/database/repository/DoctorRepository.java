package com.demo.medicaltourismapp.database.repository;

import com.demo.medicaltourismapp.database.entity.DoctorEntity;
import com.demo.medicaltourismapp.model.enums.DoctorSpecialtyEnum;
import com.demo.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends BaseRepository<DoctorEntity> {
    // patients can list available doctors according to their specialties
    List<DoctorEntity> findByDoctorSpecialtyEnum(DoctorSpecialtyEnum doctorSpecialtyEnum);
}
