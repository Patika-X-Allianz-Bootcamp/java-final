package com.allianz.patienttourism.database.entity;

import com.allianz.patienttourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hotels")
@Data
public class Hotel extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "starCount")
    private int starCount;

    @OneToMany(mappedBy = "hotel")
    private List<Room> roomList;


}
