package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.AddressEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.AddressRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.AddressResponseDTO;
import com.burakcanciftci.healthtourism.service.AddressService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
@AllArgsConstructor
public class AddressController extends BaseController<AddressEntity, AddressResponseDTO, AddressRequestDTO> {
    private final AddressService addressService;

    @Override
    protected AddressService getService() {
        return this.addressService;
    }
}
