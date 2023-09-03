package Tourism.database.entity;

import Tourism.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class HospitalEntity extends BaseEntity {

    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phoneNumber;
    @Column
    private String email;
    @Column
    private String website;
    @Column
    private String description;
    @Column
    private int numberOfBeds;
    @Column
    private int numberOfDoctors;
    @Column
    private List<String> clinics;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hospital")
    @JsonIgnore
    private List<PatientEntity> patientList;
    @Getter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hospital", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<DoctorEntity> doctorList;

    @JsonManagedReference
    public void setDoctorList(List<DoctorEntity> doctorList) {
        this.doctorList = doctorList;
    }
}