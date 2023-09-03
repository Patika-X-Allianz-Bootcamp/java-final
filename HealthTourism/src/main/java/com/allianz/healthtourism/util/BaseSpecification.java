package com.allianz.healthtourism.util;

import com.allianz.healthtourism.util.dbUtil.BaseEntity;
import org.springframework.data.jpa.domain.Specification;

public abstract class BaseSpecification<Entity extends BaseEntity> implements Specification<Entity> {
}
