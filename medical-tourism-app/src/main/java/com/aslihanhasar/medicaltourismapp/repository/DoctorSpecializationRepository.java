package com.aslihanhasar.medicaltourismapp.repository;

import com.aslihanhasar.medicaltourismapp.entity.DoctorSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization, Long> {
    boolean existsByNameIgnoreCase(String specializationName);

    boolean existsByDepartmentCodeIgnoreCase(String departmentCode);

}
