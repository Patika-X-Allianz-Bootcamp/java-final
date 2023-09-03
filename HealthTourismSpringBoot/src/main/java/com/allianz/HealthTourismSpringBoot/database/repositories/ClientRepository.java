package com.allianz.HealthTourismSpringBoot.database.repositories;

import com.allianz.HealthTourismSpringBoot.database.entities.ClientEntity;
import com.allianz.HealthTourismSpringBoot.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends IBaseRepository<ClientEntity> {
}
