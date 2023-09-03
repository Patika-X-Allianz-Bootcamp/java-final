package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.AddressEntity;
import com.burakcanciftci.healthtourism.database.repository.AddressEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.AddressSpecification;
import com.burakcanciftci.healthtourism.mapper.AddressMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.AddressRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.AddressResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressService extends BaseService<AddressEntity, AddressResponseDTO, AddressRequestDTO> {

    private final AddressEntityRepository addressEntityRepository;
    private final AddressMapper addressMapper;
    private final AddressSpecification addressSpecification;

    @Override
    protected AddressMapper getMapper() {
        return this.addressMapper;
    }

    @Override
    protected AddressEntityRepository getRepository() {
        return this.addressEntityRepository;
    }

    @Override
    protected AddressSpecification getSpecification() {
        return addressSpecification;
    }
}