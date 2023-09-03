package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Users;
import com.allianz.meliorator.database.repository.UsersRepository;
import com.allianz.meliorator.database.specification.UsersSpecification;
import com.allianz.meliorator.mapper.UsersMapper;
import com.allianz.meliorator.model.dto.UsersDTO;
import com.allianz.meliorator.model.requestDTO.UsersRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService extends BaseService<Users, UsersDTO, UsersRequestDTO, UsersMapper,
        UsersRepository, UsersSpecification> {
    @Autowired
    UsersSpecification usersSpecification;

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UsersMapper usersMapper;
    @Override
    protected UsersMapper getMapper() {
        return this.usersMapper;
    }

    @Override
    protected UsersRepository getRepository() {
        return this.usersRepository;
    }

    @Override
    protected UsersSpecification getSpecification() {
        return this.usersSpecification;
    }
}
