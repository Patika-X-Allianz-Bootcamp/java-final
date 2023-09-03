package Tourism.controller;

import Tourism.database.entity.DoctorEntity;
import Tourism.database.repository.DoctorRepository;
import Tourism.database.specification.DoctorSpecification;
import Tourism.mapper.DoctorMapper;
import Tourism.model.DoctorDTO;
import Tourism.model.requestDTO.RequestDoctorDTO;
import Tourism.service.DoctorService;
import Tourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<
        DoctorEntity,
        DoctorDTO,
        RequestDoctorDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification,
        DoctorService> {

    @Autowired
    DoctorService doctorService;

    @Override
    protected DoctorService getService() {
        return this.doctorService;
    }
}