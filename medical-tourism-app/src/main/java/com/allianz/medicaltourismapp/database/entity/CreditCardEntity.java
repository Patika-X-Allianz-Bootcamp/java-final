package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.LazyToOne;

import java.util.UUID;

@Data
@Entity
@Table(name = "creditcards")
public class CreditCardEntity extends BaseEntity {
    @Column
    private String clientName;
    @Column
    private String ccNumber;
    @Column
    private int ccBudget;
    @Column
    private int exDate;
    @Column
    private int ccPassword;


}
