package allianz.healthtourism.controller;

import allianz.healthtourism.dto.Response.PatientDTO;
import allianz.healthtourism.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class HealthTourismController {

    @Autowired
    private DoctorService doctorService;



    @PostMapping("/assign-patient")
    public ResponseEntity<String> assignPatientToDoctor(@RequestParam UUID doctorUuid, @RequestParam UUID patientUuid) {
        doctorService.assignPatientToDoctor(doctorUuid, patientUuid);
        return new ResponseEntity<>("Patient successfully assigned to doctor", HttpStatus.OK);
    }

    @GetMapping("/list-assigned-patients")
    public ResponseEntity<List<PatientDTO>> listAssignedPatients(@RequestParam UUID doctorUuid) {
        List<PatientDTO> assignedPatients = doctorService.listAssignedPatients(doctorUuid);
        return new ResponseEntity<>(assignedPatients, HttpStatus.OK);
    }

}
