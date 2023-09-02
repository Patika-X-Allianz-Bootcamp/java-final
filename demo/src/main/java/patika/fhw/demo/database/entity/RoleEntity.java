package patika.fhw.demo.database.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import patika.fhw.demo.util.dbutil.BaseEntity;


@Entity
@Data
@Table
public class RoleEntity extends BaseEntity {
    @Column(unique = true)
    private String name;
    @Column
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;


    public RoleEntity() {

    }



}