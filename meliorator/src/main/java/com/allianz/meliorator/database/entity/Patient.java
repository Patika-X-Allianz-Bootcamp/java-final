package com.allianz.meliorator.database.entity;
import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="patients")
public class Patient extends BaseEntity {
    @Column
    private String name;
    @Column
    private String surname;

}
