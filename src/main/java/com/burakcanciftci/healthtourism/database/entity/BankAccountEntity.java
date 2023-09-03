package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import com.burakcanciftci.healthtourism.util.dbutil.CompanyEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "bank_uuid"
        )
)
@Data
public class BankAccountEntity extends BaseEntity {
    @ManyToOne
    CompanyEntity company;

    @Column
    BigDecimal amount;

    @Column
    String ibanCode;
}
