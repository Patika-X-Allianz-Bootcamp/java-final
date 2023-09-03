package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import com.allianz.healthtourism.util.security.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonEntity extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserEntity user;
}