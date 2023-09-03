package Tourism.database.entity;


import Tourism.model.enums.SexEnum;
import Tourism.model.enums.TitleEnum;
import Tourism.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class DoctorEntity extends BaseEntity {

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @Column
    private String expertise;
    @Enumerated(EnumType.STRING)
    private TitleEnum title;
    @Enumerated(EnumType.STRING)
    private SexEnum sex;
    @Column
    private boolean isOperationDay;
    @Column
    private int appointmentCapacity; //needs to be dynamitasied.
    @Getter
    @ManyToOne
    @JsonIgnore
    private HospitalEntity hospital;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    @JsonIgnore
    private List<AppointmentEntity> appointmentList;

    @JsonBackReference
    public void setHospital(HospitalEntity hospital) {
        this.hospital = hospital;
    }
}