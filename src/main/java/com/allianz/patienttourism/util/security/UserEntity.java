package com.allianz.patienttourism.util.security;


import com.allianz.patienttourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class UserEntity extends BaseEntity {


    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;


    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude

    private RoleEntity role;


    public UserEntity() {


      //  roles.add(new RoleEntity("user"));
    }
}
