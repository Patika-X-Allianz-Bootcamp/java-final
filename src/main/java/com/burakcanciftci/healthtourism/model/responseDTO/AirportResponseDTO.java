package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.database.entity.PlaneEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.BankAccountRequestDTO;
import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class AirportResponseDTO extends BaseDTO {
    String name;
    AddressResponseDTO address;
    Set<BankAccountRequestDTO> bankAccountSet = new HashSet<>();
    Set<PlaneEntity> planeList = new HashSet<>();
}
