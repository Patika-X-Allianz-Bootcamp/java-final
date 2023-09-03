package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "testResults")
@Data
public class TestResultEntity extends BaseEntity {

    @Column
    private String testName;
    @Column
    private String result;
    @Temporal(TemporalType.DATE)
    private Date resultDate;

}
