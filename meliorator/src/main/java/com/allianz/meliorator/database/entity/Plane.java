package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "plane")
@Data
public class Plane extends BaseEntity {
    @OneToOne
    private Seat seat;
    @Column
    private String Model;
    @Column
    private String CompanyName;

}
