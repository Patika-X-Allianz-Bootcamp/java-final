package allianz.healthtourism.entity;

import allianz.healthtourism.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class TravelPlan extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @OneToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
