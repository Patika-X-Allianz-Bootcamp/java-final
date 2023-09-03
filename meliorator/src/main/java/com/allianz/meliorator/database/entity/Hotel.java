package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.model.enums.ClassTypeEnum;
import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name="hotels")
@Data
public class Hotel extends BaseEntity {
    @Column
    private String name;
    @Column
    private int star;
    @Column
    private ClassTypeEnum classTypeEnum;

    @OneToMany
    @JoinColumn(name = "hotel_entity_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private List<Room> room;


}
