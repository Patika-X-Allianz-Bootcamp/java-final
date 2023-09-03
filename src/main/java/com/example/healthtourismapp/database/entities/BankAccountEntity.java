package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class BankAccountEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String IBAN;

    @Column
    private double amount;
}
