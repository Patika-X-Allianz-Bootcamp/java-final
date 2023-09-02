package patika.fhw.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import patika.fhw.demo.database.entity.Doctor;
import patika.fhw.demo.database.repository.DoctorRepository;
import patika.fhw.demo.database.specification.DoctorSpecification;
import patika.fhw.demo.mapper.DoctorMapper;
import patika.fhw.demo.model.dto.DoctorDTO;
import patika.fhw.demo.model.requestDTO.DoctorRequestDTO;
import patika.fhw.demo.service.DoctorService;
import patika.fhw.demo.util.BaseController;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<
        Doctor,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification,
        DoctorService> {

    @Autowired
    private DoctorService doctorService;

    @Override
    protected DoctorService getService() {
        return doctorService;
    }
}
