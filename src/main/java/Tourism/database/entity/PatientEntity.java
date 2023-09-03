package Tourism.database.entity;


import Tourism.model.enums.SexEnum;
import Tourism.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Table
@Getter
@Setter
public class PatientEntity extends BaseEntity {

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @Column
    private String illness;
    @Enumerated(EnumType.STRING)
    private SexEnum sex;
    @Column
    private List<String> symptomList;
    @Column
    private String report; //needs to initialized with doctor report;
    @Column
    private boolean hasAppointment;
    @ManyToOne
    @JsonIgnore
    private HotelEntity accommodation;
    @ManyToOne
    @JsonIgnore
    private FlightEntity flight;
    @ManyToOne
    @JsonIgnore
    private HospitalEntity hospital;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @JsonIgnore
    private List<AppointmentEntity> appointmentList;


}