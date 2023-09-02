package patika.fhw.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import patika.fhw.demo.database.entity.Appointment;
import patika.fhw.demo.database.repository.AppointmentRepository;
import patika.fhw.demo.database.specification.AppointmentSpecification;
import patika.fhw.demo.mapper.AppointmentMapper;
import patika.fhw.demo.model.dto.AppointmentDTO;
import patika.fhw.demo.model.requestDTO.AppointmentRequestDTO;
import patika.fhw.demo.service.AppointmentService;
import patika.fhw.demo.util.BaseController;

@RestController
@RequestMapping("appointment")
public class AppointmentController extends BaseController<
        Appointment,
        AppointmentDTO,
        AppointmentRequestDTO,
        AppointmentMapper,
        AppointmentRepository,
        AppointmentSpecification,
        AppointmentService> {

    @Autowired
    private AppointmentService appointmentService;

    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }
}
