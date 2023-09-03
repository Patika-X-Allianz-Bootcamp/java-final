package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.model.enums.CountryEnum;
import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "address_uuid"
        )
)
@Data
public class AddressEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    CountryEnum country;

    @Column
    String city;

    @Column
    String address;

    @Column
    int zipCode;
}
