package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "planeSeat_uuid"
        )
)
@Data
public class PlaneSeatEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    PlaneEntity plane;

    @Column
    String seatCode;

    @Column
    BigDecimal ticketPrice;
}
