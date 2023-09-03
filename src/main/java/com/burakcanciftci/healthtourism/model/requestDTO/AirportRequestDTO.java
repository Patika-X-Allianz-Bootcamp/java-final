package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.database.entity.PlaneEntity;
import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class AirportRequestDTO extends BaseDTO {
    String name;
    AddressRequestDTO address;
    Set<BankAccountRequestDTO> bankAccountSet = new HashSet<>();
    Set<PlaneEntity> planeList = new HashSet<>();
}
