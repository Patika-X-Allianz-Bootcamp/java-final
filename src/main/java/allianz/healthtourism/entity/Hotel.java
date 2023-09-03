package allianz.healthtourism.entity;

import allianz.healthtourism.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Hotel extends BaseEntity {

    private String name;

    private String location;

    private boolean isConfirmed;  // Rezervasyon onay durumu

    private boolean isInvalid;  // Rezervasyon geçerlilik durumu

    private LocalDateTime createdAt = LocalDateTime.now();

}
