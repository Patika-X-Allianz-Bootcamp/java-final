package patika.fhw.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import patika.fhw.demo.database.entity.AdminEntity;
import patika.fhw.demo.database.entity.Doctor;
import patika.fhw.demo.database.entity.Patient;
import patika.fhw.demo.database.entity.UserEntity;
import patika.fhw.demo.model.requestDTO.LoginRequestDTO;
import patika.fhw.demo.service.AdminService;
import patika.fhw.demo.service.DoctorService;
import patika.fhw.demo.service.PatientService;
import patika.fhw.demo.service.UserService;
import patika.fhw.demo.util.security.JWTUtil;

@RestController
@RequestMapping("auth")
public class AuthorizationController {


    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    UserService userService;
    @Autowired
    PatientService patientService;
    @Autowired
    AdminService adminService; 
    @Autowired 
    DoctorService doctorService;


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


    @PostMapping("user-register")
    public ResponseEntity<Boolean> loginHandler(@RequestBody UserEntity body) {
        userService.saveUserByRole(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("admin-register")
    public ResponseEntity<Boolean> loginHandler(@RequestBody AdminEntity body) {
        adminService.saveAdminByRole(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("patient-register")
    public ResponseEntity<Boolean> loginHandler(@RequestBody Patient body) {
        patientService.savePatientByRole(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("doctor-register")
    public ResponseEntity<Boolean> loginHandler(@RequestBody Doctor body) {
        doctorService.saveDoctorByRole(body);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }


}