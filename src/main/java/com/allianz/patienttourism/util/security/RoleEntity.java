package com.allianz.patienttourism.util.security;

import com.allianz.patienttourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;


@Entity
@Data
@Table
public class RoleEntity extends BaseEntity {
    @Column(unique = true)
    private String name;
    @Column
    private String description;

    @ManyToMany(mappedBy = "role")
    private Set<UserEntity> users;

    public RoleEntity(String name) {
        this.name = name;
    }

    public RoleEntity() {

    }
}