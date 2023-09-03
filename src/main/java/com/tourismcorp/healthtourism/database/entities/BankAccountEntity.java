package com.tourismcorp.healthtourism.database.entities;

import com.tourismcorp.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table
@Data
public class BankAccountEntity extends BaseEntity {

    @Column
    private String bankName;
    @Column(unique = true)
    private String accountNumber;
    @Column
    private BigDecimal balance;


}
