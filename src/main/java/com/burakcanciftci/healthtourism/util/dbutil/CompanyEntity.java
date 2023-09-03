package com.burakcanciftci.healthtourism.util.dbutil;

import com.burakcanciftci.healthtourism.database.entity.AddressEntity;
import com.burakcanciftci.healthtourism.database.entity.BankAccountEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entity_type", discriminatorType = DiscriminatorType.STRING)
@Data
public abstract class CompanyEntity extends BaseEntity{
    @Column
    String name;

    @OneToOne
    AddressEntity address;

    @OneToMany(mappedBy = "company")
    Set<BankAccountEntity> bankAccountSet = new HashSet<>();
}
