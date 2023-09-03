package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.CustomerEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.CustomerRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.CustomerResponseDTO;
import com.burakcanciftci.healthtourism.service.CustomerService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController extends BaseController<CustomerEntity, CustomerResponseDTO, CustomerRequestDTO> {
    private final CustomerService customerService;

    @Override
    protected CustomerService getService() {
        return this.customerService;
    }
}
