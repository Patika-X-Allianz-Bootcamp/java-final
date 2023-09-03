package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Person;
import com.allianz.meliorator.database.repository.PersonRepository;
import com.allianz.meliorator.database.specification.PersonSpecification;
import com.allianz.meliorator.mapper.PersonMapper;
import com.allianz.meliorator.model.dto.PersonDTO;
import com.allianz.meliorator.model.requestDTO.PersonRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<Person, PersonDTO, PersonRequestDTO,
        PersonMapper, PersonRepository, PersonSpecification> {
    @Autowired
    PersonSpecification personSpecification;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonRepository personRepository;
    @Override
    protected PersonMapper getMapper() {
        return this.personMapper;
    }

    @Override
    protected PersonRepository getRepository() {
        return this.personRepository;
    }

    @Override
    protected PersonSpecification getSpecification() {
        return this.personSpecification;
    }
}
