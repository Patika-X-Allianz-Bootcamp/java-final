package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.model.BankAccountDTO;
import com.tourismcorp.healthtourism.model.RoomDTO;
import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelRequestDTO extends BaseDTO {


    private String hotelName;


    private String phoneNumber;


    private String email;

    private List<RoomRequestDTO> room;


    private BankAccountRequestDTO bankAccount;

}
