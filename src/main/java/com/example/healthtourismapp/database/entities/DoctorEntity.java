package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class DoctorEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String surname;

    @Column
    private int age;

    @Column
    private String title;

}
