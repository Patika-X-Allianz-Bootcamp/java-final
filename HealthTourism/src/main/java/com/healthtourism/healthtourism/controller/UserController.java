package com.healthtourism.healthtourism.controller;

import com.healthtourism.healthtourism.Specification.UserSpecification;
import com.healthtourism.healthtourism.database.entities.UserEntity;
import com.healthtourism.healthtourism.database.repositories.UserRepository;
import com.healthtourism.healthtourism.mapper.UserMapper;
import com.healthtourism.healthtourism.model.RequestDTO.UserRequestDTO;
import com.healthtourism.healthtourism.model.UserDTO;
import com.healthtourism.healthtourism.service.UserService;
import com.healthtourism.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController extends BaseController<
        UserEntity,
        UserDTO,
        UserRequestDTO,
        UserMapper,
        UserRepository,
        UserService,
        UserSpecification> {

    @Autowired
    UserService userService;

    @Override
    protected UserService getService() {
        return this.userService;
    }
}