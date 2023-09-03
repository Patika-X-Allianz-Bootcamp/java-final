package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Person;
import com.allianz.meliorator.database.repository.PersonRepository;
import com.allianz.meliorator.mapper.PersonMapper;
import com.allianz.meliorator.model.dto.PersonDTO;
import com.allianz.meliorator.model.requestDTO.PersonRequestDTO;
import com.allianz.meliorator.service.PersonService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController<Person, PersonDTO, PersonRequestDTO,
        PersonMapper, PersonRepository, PersonService> {
    @Autowired
    PersonService personService;
    @Override
    protected PersonService getService() {
        return this.personService;
    }
}
