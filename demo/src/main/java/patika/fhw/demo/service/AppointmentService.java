package patika.fhw.demo.service;

import org.springframework.stereotype.Service;

import patika.fhw.demo.database.entity.Appointment;
import patika.fhw.demo.database.repository.AppointmentRepository;
import patika.fhw.demo.database.specification.AppointmentSpecification;
import patika.fhw.demo.mapper.AppointmentMapper;
import patika.fhw.demo.model.dto.AppointmentDTO;
import patika.fhw.demo.model.requestDTO.AppointmentRequestDTO;
import patika.fhw.demo.util.BaseService;

@Service
public class AppointmentService extends BaseService<Appointment, AppointmentDTO, AppointmentRequestDTO, AppointmentMapper, AppointmentRepository, AppointmentSpecification> {

    private final AppointmentMapper mapper;
    private final AppointmentRepository repository;
    private final AppointmentSpecification specification;

    public AppointmentService(AppointmentMapper mapper, AppointmentRepository repository, AppointmentSpecification specification) {
        this.mapper = mapper;
        this.repository = repository;
        this.specification = specification;
    }

    @Override
    protected AppointmentMapper getMapper() {
        return mapper;
    }

    @Override
    protected AppointmentRepository getRepository() {
        return repository;
    }

    @Override
    protected AppointmentSpecification getSpecification() {
        return specification;
    }
}
