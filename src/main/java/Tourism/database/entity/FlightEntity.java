package Tourism.database.entity;

import Tourism.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table
@Getter
@Setter
public class FlightEntity extends BaseEntity {

    @Column
    private String airline;
    @Column
    private String flightNumber;
    @Column
    private String departureAirport;
    @Column
    private String arrivalAirport;
    @Column
    private LocalDateTime departureDateTime;
    @Column
    private LocalDateTime arrivalDateTime;
    @Column
    private BigDecimal price;
    @Column
    private int availableSeats;
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
   @JsonIgnore
   private List<PatientEntity> patientList;



}