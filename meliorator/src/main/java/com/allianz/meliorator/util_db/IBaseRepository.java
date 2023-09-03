package com.allianz.meliorator.util_db;

import com.allianz.meliorator.util.BaseSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface IBaseRepository<Entity extends BaseEntity> extends JpaRepository<Entity, Long> {
    Optional<Entity> findByUuid(UUID uuid);

    <Entity extends BaseEntity> Page<Entity> findAll(Specification specification, Pageable pageable);
}
