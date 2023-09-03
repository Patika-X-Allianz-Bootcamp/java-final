package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.PatientEntity;
import com.example.healthtourismapp.model.requestDTO.LoginRequestDTO;
import com.example.healthtourismapp.service.PatientService;
import com.example.healthtourismapp.util.security.JWTUtil;
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

    private final PatientService patientService;

    public AuthorizationController(AuthenticationManager authManager, JWTUtil jwtUtil, PatientService patientService) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.patientService = patientService;
    }


    @PostMapping("login")
    public Map<String, Object> loginHandler(@RequestBody LoginRequestDTO body) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

        authManager.authenticate(authInputToken);

        String token = jwtUtil.generateToken(body.getEmail());

        Map<String, Object> authorizationMap = new HashMap<>();
        authorizationMap.put("jwt-token", token);

        return authorizationMap;
    }


    @PostMapping("register")
    public ResponseEntity<Boolean> loginHandler(@RequestBody PatientEntity body) {

        patientService.saveUserByRole(body);

        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);


    }


}
