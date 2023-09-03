package Tourism.database.entity;

import Tourism.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table
@Getter
@Setter
public class AppointmentEntity extends BaseEntity {

    @Column
    private LocalDate appointmentDate;
    @ManyToOne
    @JsonIgnore
    private PatientEntity patient;
    @ManyToOne
    @JsonIgnore
    private DoctorEntity doctor;
    @Column
    private int duration;


}