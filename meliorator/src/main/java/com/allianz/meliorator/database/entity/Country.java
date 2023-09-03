package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="countries")
@Data
public class Country extends BaseEntity {
    @Column
    private String name;
    @OneToMany
    private List<City> city;
}
