package com.aslihanhasar.medicaltourismapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "hospitals")
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "hospital_id"
        )
)
public class Hospital extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String hospitalCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
    @OneToMany(mappedBy = "hospital")
    private Set<Doctor> doctors;
}
