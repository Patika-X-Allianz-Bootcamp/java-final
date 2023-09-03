package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.DoctorEntity;
import com.tourismcorp.healthtourism.database.entities.UserEntity;
import com.tourismcorp.healthtourism.model.requestDTO.LoginRequestDTO;
import com.tourismcorp.healthtourism.service.DoctorService;
import com.tourismcorp.healthtourism.service.UserService;
import com.tourismcorp.healthtourism.util.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthorizationController {


    private final AuthenticationManager authManager;

    private final JWTUtil jwtUtil;

    private final UserService userService;

    private final DoctorService doctorService;

    @Autowired
    public AuthorizationController(@Lazy AuthenticationManager authManager, @Lazy JWTUtil jwtUtil,
                                   @Lazy UserService userService, @Lazy DoctorService doctorService) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.doctorService = doctorService;
    }


    @PostMapping("login")
    public Map<String, Object> loginHandler(@RequestBody LoginRequestDTO body) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());

        authManager.authenticate(authInputToken);

        String token = jwtUtil.generateToken(body.getUsername());

        Map<String, Object> authorizationMap = new HashMap<>();
        authorizationMap.put("jwt-token", token);

        return authorizationMap;
    }


    @PostMapping("register-user")
    public ResponseEntity<Boolean> loginHandler(@RequestBody UserEntity body) {
        userService.saveUserByRole(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("register-doctor")
    public ResponseEntity<Boolean> registerDoctor(@RequestBody DoctorEntity body) {
        doctorService.saveDoctorByRole(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}