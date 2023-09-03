package com.allianz.medicaltourismapp.database.entity.roles;

import com.allianz.medicaltourismapp.database.entity.PersonEntity;
import com.allianz.medicaltourismapp.database.entity.RoleEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
@Entity
@Data
@Table(name = "hospitalSecretary")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "hospitalSecretary_uuid"
        )
)
public class HospitalSecretaryEntity extends PersonEntity {

    @Column
    private String username;
    @Column
    private boolean isEnable;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "role_id", nullable = false)
    private Set<RoleEntity> roles;


    public HospitalSecretaryEntity() {
        isEnable = false;
    }
}
