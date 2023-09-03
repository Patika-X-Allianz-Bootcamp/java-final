package Tourism.controller;

import Tourism.database.entity.HospitalEntity;
import Tourism.database.repository.HospitalRepository;
import Tourism.database.specification.HospitalSpecification;
import Tourism.mapper.HospitalMapper;
import Tourism.model.HospitalDTO;
import Tourism.model.requestDTO.RequestDoctorDTO;
import Tourism.model.requestDTO.RequestHospitalDTO;
import Tourism.service.HospitalService;
import Tourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController<
        HospitalEntity,
        HospitalDTO,
        RequestHospitalDTO,
        HospitalMapper,
        HospitalRepository,
        HospitalSpecification,
        HospitalService> {

    @Autowired
    HospitalService hospitalService;

    @Override
    protected HospitalService getService() {
        return this.hospitalService;
    }

    /*@PostMapping("add-doctor")
    public ResponseEntity<HospitalDTO> addOtherRelations(@RequestBody RequestDoctorDTO requestDoctorDTO){
        return new ResponseEntity<>(hospitalService.addDoctorToHospital(requestDoctorDTO), HttpStatus.OK);

    }*/
}