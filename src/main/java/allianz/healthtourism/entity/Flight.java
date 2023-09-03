package allianz.healthtourism.entity;

import allianz.healthtourism.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Flight extends BaseEntity {

    private String flightNumber;
    private String departure;
    private String arrival;
}
