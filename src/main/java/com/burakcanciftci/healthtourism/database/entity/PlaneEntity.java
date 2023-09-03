package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "plane_uuid"
        )
)
@Data
public class PlaneEntity extends BaseEntity {
    @Column
    String name;

    @Column
    String planeType;

    @OneToMany(mappedBy = "plane")
    List<FlightEntity> flightList = new ArrayList<>();

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)
    Set<PlaneSeatEntity> seatSet = new HashSet<>();
}
