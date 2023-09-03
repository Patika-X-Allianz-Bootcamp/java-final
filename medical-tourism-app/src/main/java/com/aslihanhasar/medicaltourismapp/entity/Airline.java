package com.aslihanhasar.medicaltourismapp.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "airlines")
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "airline_id"
        )
)
public class Airline extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String airlineName;
    @Column(nullable = false, unique = true)
    private String airlineCode;
}


