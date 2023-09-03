package com.allianz.HealthTourismSpringBoot.controller;

import com.allianz.HealthTourismSpringBoot.database.entities.ClientEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.ClientRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.ClientSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.ClientMapper;
import com.allianz.HealthTourismSpringBoot.model.ClientDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.ClientRequestDTO;
import com.allianz.HealthTourismSpringBoot.service.ClientService;
import com.allianz.HealthTourismSpringBoot.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends BaseController<ClientEntity,
        ClientDTO,
        ClientRequestDTO,
        ClientMapper,
        ClientRepository,
        ClientSpecification,
        ClientService> {

    @Autowired
    ClientService clientService;

    @Override
    protected ClientService getService() {
        return clientService;
    }
}
