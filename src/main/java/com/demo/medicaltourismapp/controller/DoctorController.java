package com.demo.medicaltourismapp.controller;

import com.demo.medicaltourismapp.database.entity.DoctorEntity;
import com.demo.medicaltourismapp.database.repository.DoctorRepository;
import com.demo.medicaltourismapp.mapper.DoctorMapper;
import com.demo.medicaltourismapp.model.DoctorDTO;
import com.demo.medicaltourismapp.model.enums.DoctorSpecialtyEnum;
import com.demo.medicaltourismapp.model.requestDTO.DoctorRequestDTO;
import com.demo.medicaltourismapp.service.DoctorService;
import com.demo.medicaltourismapp.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<DoctorEntity, DoctorDTO, DoctorRequestDTO,
        DoctorMapper, DoctorRepository, DoctorService> {

    private final DoctorService doctorService;

    @Override
    protected DoctorService getService() {
        return doctorService;
    }

    @GetMapping("get-by-specialty/{doctorSpecialtyEnum}")
    public ResponseEntity<List<DoctorDTO>> getBySpecialty(@PathVariable DoctorSpecialtyEnum doctorSpecialtyEnum) {
        List<DoctorDTO> dtoList = doctorService.getBySpecialty(doctorSpecialtyEnum);
        if (dtoList != null) {
            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
