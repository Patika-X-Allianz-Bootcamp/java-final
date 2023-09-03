package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Address;
import com.allianz.meliorator.database.repository.AddressRepository;
import com.allianz.meliorator.database.specification.AddressSpecification;
import com.allianz.meliorator.mapper.AddressMapper;
import com.allianz.meliorator.model.dto.AddressDTO;
import com.allianz.meliorator.model.requestDTO.AddressRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address, AddressDTO,
        AddressRequestDTO, AddressMapper, AddressRepository, AddressSpecification> {

    @Autowired
    AddressSpecification addressSpecification;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    AddressRepository addressRepository;
    @Override
    protected AddressMapper getMapper() {
        return this.addressMapper;
    }

    @Override
    protected AddressRepository getRepository() {
        return this.addressRepository;
    }

    @Override
    protected AddressSpecification getSpecification() {
        return this.addressSpecification;
    }
}
