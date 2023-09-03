package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="cities")
@Data
public class City extends BaseEntity {
    @Column
    private String name;
    @Column
    private String airport;
}
