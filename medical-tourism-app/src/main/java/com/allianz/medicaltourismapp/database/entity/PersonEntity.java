package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Data
@EntityListeners({AuditingEntityListener.class})
public class PersonEntity extends BaseEntity {
    private String firstname;

    private String lastname;

    private String password;

    private String email;}
