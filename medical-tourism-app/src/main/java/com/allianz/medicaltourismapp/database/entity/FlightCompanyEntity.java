package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "flightCompanies")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "flightCompany_uuid"
        )
)
public class FlightCompanyEntity extends BaseEntity {
    @Column
    private String flightCompanyName;
    @Column
    private String flightCompanyAddress;
    @Column
    private String flightCompanyPhone;

    @OneToMany
    private List<FlightEntity> flights;
}
