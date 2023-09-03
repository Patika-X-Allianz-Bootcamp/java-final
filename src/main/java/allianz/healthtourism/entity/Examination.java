package allianz.healthtourism.entity;

import allianz.healthtourism.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Examination extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    private String notes;
}
