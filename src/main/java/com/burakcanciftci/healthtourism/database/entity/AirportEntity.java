package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.CompanyEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Data
public class AirportEntity extends CompanyEntity {
    @OneToMany
    Set<PlaneEntity> planeList = new HashSet<>();
}
