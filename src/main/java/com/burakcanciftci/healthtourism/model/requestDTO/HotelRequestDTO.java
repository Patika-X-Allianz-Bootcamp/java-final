package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class HotelRequestDTO extends BaseDTO {
    String name;
    AddressRequestDTO address;
    Set<BankAccountRequestDTO> bankAccountSet = new HashSet<>();
    List<HotelRoomRequestDTO> roomList = new ArrayList<>();
}
