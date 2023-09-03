package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name="bills")
@Data
public class Bill extends BaseEntity {
    @Column(unique = true)
    private String billNo;

    @Column
    private LocalDateTime billDate;

    @Column
    private BigDecimal taxRate;

    @Column
    private BigDecimal taxAmount;

    @Column
    private BigDecimal totalSellNetPrice;

    @Column
    private BigDecimal totalSellPrice;

}
