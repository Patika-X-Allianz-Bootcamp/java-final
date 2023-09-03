package com.tourismcorp.healthtourism.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface IBaseRepository<Entity extends BaseEntity> extends JpaRepository<Entity, Long> {
    Optional<Entity> findByUuid(UUID uuid);

    Page<Entity> findAll(Specification<Entity> specification, Pageable pageable);
}

