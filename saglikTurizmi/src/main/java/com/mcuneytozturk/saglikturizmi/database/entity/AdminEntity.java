package com.mcuneytozturk.saglikturizmi.database.entity;

import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "admins")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "admin_uuid"
        )
)
@Data
public class AdminEntity extends BaseEntity {
    @Column
    private String adminName;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "role_id", nullable = false)
    private Set<AdminRoleEntity> roles;
}
