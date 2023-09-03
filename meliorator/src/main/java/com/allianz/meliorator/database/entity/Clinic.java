package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Clinic extends BaseEntity {
    @Column
    private String clinicName;

}
