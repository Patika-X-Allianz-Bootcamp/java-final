package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CollectionIdType;

import java.util.List;
@Entity
@Table(name = "hospitals")
@Data
public class Hospital extends BaseEntity {
    @Column
    private String name;
    @OneToMany
    private List<Clinic> clinic;
}
