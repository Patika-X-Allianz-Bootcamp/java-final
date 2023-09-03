package com.healthtourism.healthtourism.database.entities;

import com.healthtourism.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table
public class PatientEntity extends BaseEntity {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column
    private String gender;
    @Column
    private LocalDate dateOfBirth;
    @Column(unique = true, nullable = false)
    private String phoneNumber;


}
