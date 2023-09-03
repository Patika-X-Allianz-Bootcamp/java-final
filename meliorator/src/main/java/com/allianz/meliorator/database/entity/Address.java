package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="addresses")
@AttributeOverride(name = "uuid", column = @Column(name = "address_uuid"))
@Data
public class Address extends BaseEntity {
    @Column
    private String title;
    @Column(length = 500)
    private String address;
    @ManyToOne(optional = false)
    private Person people;

    public Person getPeople() {
        return people;
    }

    public void setPeople(Person people) {
        this.people = people;
    }
}
