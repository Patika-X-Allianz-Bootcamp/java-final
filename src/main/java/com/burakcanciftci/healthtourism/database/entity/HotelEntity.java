package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.CompanyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Data
public class HotelEntity extends CompanyEntity {
    @OneToMany(mappedBy = "hotel")
    List<HotelRoomEntity> roomList = new ArrayList<>();
}
