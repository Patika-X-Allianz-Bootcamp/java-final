package Tourism.service;

import Tourism.database.entity.DoctorEntity;
import Tourism.database.repository.AppointmentRepository;
import Tourism.database.repository.DoctorRepository;
import Tourism.database.specification.AppointmentSpecification;
import Tourism.database.specification.DoctorSpecification;
import Tourism.mapper.AppointmentMapper;
import Tourism.mapper.DoctorMapper;
import Tourism.model.DoctorDTO;
import Tourism.model.HospitalDTO;
import Tourism.model.requestDTO.RequestDoctorDTO;
import Tourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class DoctorService extends BaseService<DoctorEntity, DoctorDTO, RequestDoctorDTO,
        DoctorMapper, DoctorRepository, DoctorSpecification> {

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorSpecification doctorSpecification;



    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    protected DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return doctorSpecification;
    }


}
