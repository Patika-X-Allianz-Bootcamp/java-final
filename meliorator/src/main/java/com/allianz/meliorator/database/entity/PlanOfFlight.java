package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.model.enums.ClassTypeEnum;
import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class PlanOfFlight extends BaseEntity {
    @OneToMany
    private List <Flight> flightList;
    @Column
    private int bodyCount;
    @Column
    private boolean isApproved;
    @Column
    private ClassTypeEnum classTypeEnum;

}
