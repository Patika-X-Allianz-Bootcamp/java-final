package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.model.requestDTO.AddressRequestDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.BankAccountRequestDTO;
import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class HotelResponseDTO extends BaseDTO {
    String name;
    AddressResponseDTO address;
    Set<BankAccountResponseDTO> bankAccountSet = new HashSet<>();
    List<HotelRoomResponseDTO> roomList = new ArrayList<>();
}
