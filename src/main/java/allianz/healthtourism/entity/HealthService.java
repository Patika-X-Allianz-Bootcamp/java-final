package allianz.healthtourism.entity;

import allianz.healthtourism.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class HealthService extends BaseEntity {

    private String serviceName;

    @OneToMany(mappedBy = "healthService")  //ManyToMany de olabilir
    private List<Appointment> appointments;
}
