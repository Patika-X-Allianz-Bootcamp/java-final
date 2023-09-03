package com.tourismcorp.healthtourism.database.entities;

import com.tourismcorp.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Table
@Entity
public class HotelEntity extends BaseEntity {

    @Column
    private String hotelName;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @OneToMany
    @JoinColumn(name = "hotel_entity_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private List<RoomEntity> room;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private BankAccountEntity bankAccount;

}
