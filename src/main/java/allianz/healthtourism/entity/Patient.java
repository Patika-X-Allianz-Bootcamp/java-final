package allianz.healthtourism.entity;

import allianz.healthtourism.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Patient extends BaseEntity {

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "patients")
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

}
