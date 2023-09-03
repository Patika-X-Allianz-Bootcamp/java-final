package com.burakcanciftci.healthtourism.util.dbutil;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class PersonEntity extends BaseEntity {

    @Column
    String name;

    @Column
    String surname;

    @Column(unique = true)
    String governmentID;
}
