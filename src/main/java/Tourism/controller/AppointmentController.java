package Tourism.controller;

import Tourism.database.entity.AppointmentEntity;
import Tourism.database.repository.AppointmentRepository;
import Tourism.database.specification.AppointmentSpecification;
import Tourism.mapper.AppointmentMapper;
import Tourism.model.AppointmentDTO;
import Tourism.model.HospitalDTO;
import Tourism.model.requestDTO.RequestAppointmentDTO;
import Tourism.model.requestDTO.RequestHospitalDTO;
import Tourism.service.AppointmentService;
import Tourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController extends BaseController<
        AppointmentEntity,
        AppointmentDTO,
        RequestAppointmentDTO,
        AppointmentMapper,
        AppointmentRepository,
        AppointmentSpecification,
        AppointmentService> {

    @Autowired
    AppointmentService appointmentService;

    @Override
    protected AppointmentService getService() {
        return this.appointmentService;
    }

    @PostMapping("make-appointment")
    public ResponseEntity<AppointmentDTO> makeAppointment(@RequestBody RequestAppointmentDTO requestAppointmentDTO){
        return new ResponseEntity<>(appointmentService.saveWithDoctorAndPatient(requestAppointmentDTO), HttpStatus.OK);

    }
}