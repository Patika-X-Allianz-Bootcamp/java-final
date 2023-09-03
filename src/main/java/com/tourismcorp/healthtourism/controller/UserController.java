package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.UserEntity;
import com.tourismcorp.healthtourism.database.repositories.UserRepository;
import com.tourismcorp.healthtourism.database.specification.UserSpecification;
import com.tourismcorp.healthtourism.mapper.UserMapper;
import com.tourismcorp.healthtourism.model.UserDTO;
import com.tourismcorp.healthtourism.model.requestDTO.UserRequestDTO;
import com.tourismcorp.healthtourism.service.UserService;
import com.tourismcorp.healthtourism.util.BaseController;
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
        UserSpecification,
        UserService> {

    @Autowired
    UserService userService;

    @Override
    protected UserService getService() {
        return this.userService;
    }
}
