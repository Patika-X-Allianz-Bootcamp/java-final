package com.allianz.healthtourism.util.security;

import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController extends BaseController<UserRequestDTO, UserResponseDTO, UserEntity, UserMapper, UserEntityRepository, UserSpecification, UserService> {

    private final UserService userService;

    @Override
    protected UserService getService() {
        return this.userService;
    }

}
