package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table
@Data
public class HospitalEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String hospitalName;

    @Column
    private String city;

    @OneToMany
    private List<HealthServiceEntity> healthServiceList;

    @OneToOne
    private BankAccountEntity bankAccount;


}
