package com.example.healthtourismapp.database.repositories;

import com.example.healthtourismapp.database.entities.RoleEntity;
import com.example.healthtourismapp.util.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends IBaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
