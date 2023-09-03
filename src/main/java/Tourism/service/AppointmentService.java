package Tourism.service;

import Tourism.database.entity.AppointmentEntity;
import Tourism.database.repository.AppointmentRepository;
import Tourism.database.specification.AppointmentSpecification;
import Tourism.mapper.AppointmentMapper;
import Tourism.model.AppointmentDTO;
import Tourism.model.DoctorDTO;
import Tourism.model.PatientDTO;
import Tourism.model.requestDTO.RequestAppointmentDTO;
import Tourism.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends BaseService<AppointmentEntity, AppointmentDTO, RequestAppointmentDTO,
        AppointmentMapper, AppointmentRepository, AppointmentSpecification> {

    @Autowired
    AppointmentMapper appointmentMapper;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentSpecification appointmentSpecification;

    @Autowired
    @Lazy
    DoctorService doctorService;
    @Autowired
    PatientService patientService;

    @Override
    protected AppointmentMapper getMapper() {
        return appointmentMapper;
    }

    @Override
    protected AppointmentRepository getRepository() {
        return appointmentRepository;
    }

    @Override
    protected AppointmentSpecification getSpecification() {
        return appointmentSpecification;
    }

    @Transactional
    public AppointmentDTO saveWithDoctorAndPatient(RequestAppointmentDTO requestAppointmentDTO) {

        AppointmentDTO appointmentDTO = appointmentMapper.entityToDTO(appointmentRepository.save(appointmentMapper.requestDTOToEntity(requestAppointmentDTO)));

        DoctorDTO doctorDTO = doctorService.getByUUID(requestAppointmentDTO.getDoctor().getUuid());
        PatientDTO patientDTO = patientService.getByUUID(requestAppointmentDTO.getPatient().getUuid());
        if (requestAppointmentDTO.getDoctor().getName().equals(doctorDTO.getName()) &&
                requestAppointmentDTO.getDoctor().getSurname().equals(doctorDTO.getSurname())) {
            appointmentDTO.setDoctor(doctorDTO);
        } else {
            appointmentDTO.setDoctor(null);
        }

        if (requestAppointmentDTO.getPatient().getName().equals(patientDTO.getName()) &&
                requestAppointmentDTO.getPatient().getSurname().equals(patientDTO.getSurname())) {
            appointmentDTO.setPatient(patientDTO);
        } else {
            appointmentDTO.setPatient(null);
        }

        getRepository().save(appointmentMapper.dtoToEntity(appointmentDTO));
        return appointmentDTO;
    }
}
