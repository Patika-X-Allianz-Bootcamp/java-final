package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.CustomerEntity;
import com.burakcanciftci.healthtourism.database.repository.CustomerEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.CustomerSpecification;
import com.burakcanciftci.healthtourism.mapper.CustomerMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.CustomerRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.CustomerResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerResponseDTO, CustomerRequestDTO> {

    private final CustomerEntityRepository customerEntityRepository;
    private final CustomerMapper customerMapper;
    private final CustomerSpecification customerSpecification;

    @Override
    protected CustomerMapper getMapper() {
        return this.customerMapper;
    }

    @Override
    protected CustomerEntityRepository getRepository() {
        return this.customerEntityRepository;
    }

    @Override
    protected CustomerSpecification getSpecification() {
        return customerSpecification;
    }
}