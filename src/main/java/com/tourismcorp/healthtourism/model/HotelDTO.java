package com.tourismcorp.healthtourism.model;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelDTO extends BaseDTO {


    private String hotelName;


    private String phoneNumber;


    private String email;

    private List<RoomDTO> room;


    private BankAccountDTO bankAccount;

}
