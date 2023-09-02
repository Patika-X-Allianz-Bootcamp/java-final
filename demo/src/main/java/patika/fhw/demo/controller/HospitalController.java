package patika.fhw.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import patika.fhw.demo.database.entity.Hospital;
import patika.fhw.demo.database.repository.HospitalRepository;
import patika.fhw.demo.database.specification.HospitalSpecification;
import patika.fhw.demo.mapper.HospitalMapper;
import patika.fhw.demo.model.dto.HospitalDTO;
import patika.fhw.demo.model.requestDTO.HospitalRequestDTO;
import patika.fhw.demo.service.HospitalService;
import patika.fhw.demo.util.BaseController;

@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController<
        Hospital,
        HospitalDTO,
        HospitalRequestDTO,
        HospitalMapper,
        HospitalRepository,
        HospitalSpecification,
        HospitalService> {

    @Autowired
    private HospitalService hospitalService;

    @Override
    protected HospitalService getService() {
        return hospitalService;
    }
}
