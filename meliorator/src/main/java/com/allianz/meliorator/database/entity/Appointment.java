package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="appointments")
public class Appointment extends BaseEntity {
    @OneToOne
    private Patient patient;
    @OneToOne
    private Doctor doctor;
    @Column
    private LocalDateTime startDate;
    @Column
    private LocalDateTime endDate;
    @Column
    private boolean isApproved;
    @Column(columnDefinition = "text")
    private String report;
}
