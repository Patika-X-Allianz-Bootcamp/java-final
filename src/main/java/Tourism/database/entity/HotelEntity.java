package Tourism.database.entity;

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
public class HotelEntity extends BaseEntity {

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
    private int starRating;
    @Column
    private int roomCapacity;
    @Column
    private boolean isPetFriendly;
    @Column
    private String description;
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "accommodation")
   @JsonIgnore
   private List<PatientEntity> patientList;




}