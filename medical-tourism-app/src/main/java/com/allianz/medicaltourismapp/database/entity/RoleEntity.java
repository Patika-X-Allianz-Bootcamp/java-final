package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.database.entity.roles.AdminEntity;
import com.allianz.medicaltourismapp.database.entity.roles.HospitalSecretaryEntity;
import com.allianz.medicaltourismapp.database.entity.roles.UserEntity;
import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Entity
@Data
@Table
public class RoleEntity extends BaseEntity {

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;

    @ManyToMany(mappedBy = "roles")
    private Set<AdminEntity> admins;

    @ManyToMany(mappedBy = "roles")
    private Set<HospitalSecretaryEntity> hospitalSecretary;


    public RoleEntity() {

    }
}
