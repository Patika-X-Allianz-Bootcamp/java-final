package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Address;
import com.allianz.meliorator.database.repository.AddressRepository;
import com.allianz.meliorator.mapper.AddressMapper;
import com.allianz.meliorator.model.dto.AddressDTO;
import com.allianz.meliorator.model.requestDTO.AddressRequestDTO;
import com.allianz.meliorator.service.AddressService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<Address, AddressDTO, AddressRequestDTO,
        AddressMapper, AddressRepository, AddressService> {

    @Autowired
    AddressService addressService;
    @Override
    protected AddressService getService() {
        return this.addressService;
    }
}
