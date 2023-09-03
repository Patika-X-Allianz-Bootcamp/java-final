package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.model.enums.GenderEnum;
import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@Component
public class PatientEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String surname;

    @Column
    private int age;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column
    private String tc;

    @OneToMany
    private List<BankAccountEntity> bankAccount;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "role_id", nullable = false)
    private Set<RoleEntity> roles;





}
