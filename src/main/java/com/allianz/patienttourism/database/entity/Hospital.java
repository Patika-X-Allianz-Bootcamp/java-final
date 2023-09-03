package com.allianz.patienttourism.database.entity;

import com.allianz.patienttourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hospitals")
@Data
public class Hospital extends BaseEntity {

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "hospital")
    List<Doctor> doctorList;


}
