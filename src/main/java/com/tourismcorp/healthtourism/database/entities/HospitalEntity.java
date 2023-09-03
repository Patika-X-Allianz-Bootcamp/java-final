package com.tourismcorp.healthtourism.database.entities;

import com.tourismcorp.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Table
@Entity
public class HospitalEntity extends BaseEntity {
    @Column
    private String hospitalName;
    @Column
    private String phoneNumber;
    @Column
    private String email;

    @OneToMany
    @JoinColumn(name = "hospital_entity_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private List<DoctorEntity> doctor;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private BankAccountEntity bankAccount;
}
