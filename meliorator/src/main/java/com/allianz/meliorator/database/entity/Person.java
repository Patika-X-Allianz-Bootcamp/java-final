package com.allianz.meliorator.database.entity;
import com.allianz.meliorator.model.enums.SexTypeEnum;
import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="persons")
public class Person extends BaseEntity {
    @Column
    private String name;
    @Column
    private String surname;
    private String password;
    @Column
    private String identityNumber;
    @Enumerated(EnumType.STRING)
    private SexTypeEnum sexTypeEnum;
    @Column
    private Date birthdate;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Address> address;
    @Column
    private String phoneNumber;
    @Column
    private String email;

}
