package Tourism.service;

import Tourism.database.entity.DoctorEntity;
import Tourism.database.entity.HospitalEntity;
import Tourism.database.repository.HospitalRepository;
import Tourism.database.specification.HospitalSpecification;
import Tourism.mapper.HospitalMapper;
import Tourism.model.DoctorDTO;
import Tourism.model.HospitalDTO;
import Tourism.model.requestDTO.RequestDoctorDTO;
import Tourism.model.requestDTO.RequestHospitalDTO;
import Tourism.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class HospitalService extends BaseService<HospitalEntity, HospitalDTO, RequestHospitalDTO,
        HospitalMapper, HospitalRepository, HospitalSpecification> {

    @Autowired
    HospitalMapper hospitalMapper;

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    HospitalSpecification hospitalSpecification;

    @Autowired
    DoctorService doctorService;

    @Override
    protected HospitalMapper getMapper() {
        return hospitalMapper;
    }

    @Override
    protected HospitalRepository getRepository() {
        return hospitalRepository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return hospitalSpecification;
    }


   /* public HospitalDTO addDoctor(UUID doctorUuid, UUID hospitalUuid) {

        DoctorDTO doctorDTO = doctorService.getByUUID(doctorUuid);
        HospitalDTO hospitalDTO = getByUUID(hospitalUuid);

        if (doctorDTO != null && hospitalDTO != null) {
            doctorDTO.setHospital(hospitalDTO);
            if(hospitalDTO.getDoctorList()!=null){
                hospitalDTO.getDoctorList().add(doctorDTO);
            }else {
                ArrayList<DoctorDTO> doctorDTOS = new ArrayList<>();
                doctorDTOS.add(doctorDTO);
                hospitalDTO.setDoctorList(doctorDTOS);
            }
        }
        doctorService.getRepository().save(doctorService.getMapper().dtoToEntity(doctorDTO));
        getRepository().save(getMapper().dtoToEntity(hospitalDTO));
        return hospitalDTO;


    }*/
}


    /*
    @Transactional
    public HospitalDTO saveWithDoctor(RequestHospitalDTO hospitalRequestDto) {

        ArrayList<RequestDoctorDTO> requestDoctorDTOS = new ArrayList<>(hospitalRequestDto.getDoctorList());
        hospitalRequestDto.setDoctorList(null);
        HospitalDTO hospitalDTO = hospitalMapper.entityToDTO(hospitalRepository.save(hospitalMapper.requestDTOToEntity(hospitalRequestDto)));
        for (RequestDoctorDTO requestDoctorDTO : requestDoctorDTOS) {
            if (hospitalDTO.getDoctorList() != null) {
                hospitalDTO.getDoctorList().add(doctorService.getByUUID(requestDoctorDTO.getUuid()));
                doctorService.getByUUID(requestDoctorDTO.getUuid()).setHospital(hospitalDTO);
               //doctorService.getRepository().save(doctorService.getMapper().dtoToEntity(requestDoctorDTO.getUuid()));

            } else {
                ArrayList<DoctorDTO> doctorDTOS = new ArrayList<>();
                doctorDTOS.add(doctorService.getByUUID(requestDoctorDTO.getUuid()));
                hospitalDTO.setDoctorList(doctorDTOS);
                doctorService.getByUUID(requestDoctorDTO.getUuid()).setHospital(hospitalDTO);
                doctorService.getRepository().save(doctorService.getMapper().requestDTOToEntity(requestDoctorDTO));

            }
        }
        getRepository().save(hospitalMapper.dtoToEntity(hospitalDTO));
        return hospitalDTO;


    }
     */

