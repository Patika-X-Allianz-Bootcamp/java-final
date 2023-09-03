package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "housing_table")
@Data
public class Housing extends BaseEntity {
    @OneToMany
    private List<Patient> person;
    @Column
    private int bodyCount;
    @Column
    private boolean isApproved;


}
