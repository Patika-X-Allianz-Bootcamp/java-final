package com.allianz.healthtourism.util.security;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.entity.PersonEntity;
import com.allianz.healthtourism.util.dbutil.BaseEntity;
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
    private String username;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column
    private String photoLink;
    @Column
    private boolean isEnable;

    @ManyToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "role_id", nullable = false)
    private Set<RoleEntity> roles = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PersonEntity person;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "app_id")
//    private AppEntity app;


    public UserEntity() {
        isEnable = false;
        roles.add(new RoleEntity("user"));
    }

}
