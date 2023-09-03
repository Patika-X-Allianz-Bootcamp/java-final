package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.PersonEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "customer_uuid"
        )
)
@Data
public class CustomerEntity extends PersonEntity {
    @OneToMany(mappedBy = "customer")
    List<TravelPlanEntity> travelPlanList = new ArrayList<>();
}
