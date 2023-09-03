package com.allianz.HealthTourismSpringBoot.service;

import com.allianz.HealthTourismSpringBoot.database.entities.ClientEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.ClientRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.ClientSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.ClientMapper;
import com.allianz.HealthTourismSpringBoot.model.ClientDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.ClientRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends BaseService<
        ClientEntity,
        ClientDTO,
        ClientRequestDTO,
        ClientMapper,
        ClientRepository,
        ClientSpecification> {

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientSpecification clientSpecification;

    @Override
    public ClientMapper getMapper() {
        return clientMapper;
    }

    @Override
    public ClientRepository getRepository() {
        return clientRepository;
    }

    @Override
    protected ClientSpecification getSpecification() {
        return clientSpecification;
    }
}
