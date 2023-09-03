package com.healthtourism.healthtourism.mapper;
import com.healthtourism.healthtourism.database.entities.MedicalRecordEntity;
import com.healthtourism.healthtourism.model.MedicalRecordDTO;
import com.healthtourism.healthtourism.model.RequestDTO.MedicalRecordRequestDTO;
import com.healthtourism.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class MedicalRecordMapper implements IBaseMapper<MedicalRecordEntity, MedicalRecordDTO, MedicalRecordRequestDTO> {
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public MedicalRecordDTO entityToDTO(MedicalRecordEntity medicalRecordEntity) {
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO();
        medicalRecordDTO.setPatient(patientMapper.entityToDTO(medicalRecordEntity.getPatient()));
        medicalRecordDTO.setDoctor(doctorMapper.entityToDTO(medicalRecordEntity.getDoctor()));
        medicalRecordDTO.setId(medicalRecordEntity.getId());
        medicalRecordDTO.setUuid(medicalRecordEntity.getUuid());
        medicalRecordDTO.setExaminationDateTime(medicalRecordEntity.getExaminationDateTime());
        medicalRecordDTO.setExaminationNotes(medicalRecordEntity.getExaminationNotes());

        return medicalRecordDTO;
    }

    @Override
    public MedicalRecordEntity dtoToEntity(MedicalRecordDTO medicalRecordDTO) {
        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        medicalRecordEntity.setDoctor(doctorMapper.dtoToEntity(medicalRecordDTO.getDoctor()));
        medicalRecordEntity.setPatient(patientMapper.dtoToEntity(medicalRecordDTO.getPatient()));
        medicalRecordEntity.setId(medicalRecordDTO.getId());
        medicalRecordEntity.setUuid(medicalRecordDTO.getUuid());
        medicalRecordEntity.setExaminationDateTime(medicalRecordDTO.getExaminationDateTime());
        medicalRecordEntity.setCreationDate(medicalRecordDTO.getCreationDate());
        medicalRecordEntity.setUpdatedDate(medicalRecordDTO.getUpdatedDate());
        medicalRecordEntity.setExaminationNotes(medicalRecordDTO.getExaminationNotes());
        return medicalRecordEntity;
    }


    @Override
    public List<MedicalRecordDTO> entityListToDTOList(List<MedicalRecordEntity> medicalRecordEntities) {
        List<MedicalRecordDTO> medicalRecordDTOList = new ArrayList<>();

        for (MedicalRecordEntity medicalRecordEntity : medicalRecordEntities) {
            medicalRecordDTOList.add(entityToDTO(medicalRecordEntity));
        }

        return medicalRecordDTOList;
    }

    @Override
    public List<MedicalRecordEntity> dtoListToEntityList(List<MedicalRecordDTO> medicalRecordDTOS) {
        List<MedicalRecordEntity> medicalRecordEntityList = new ArrayList<>();

        for (MedicalRecordDTO medicalRecordDTO : medicalRecordDTOS) {
            medicalRecordEntityList.add(dtoToEntity(medicalRecordDTO));
        }
        return medicalRecordEntityList;
    }

    @Override
    public MedicalRecordEntity requestDTOToEntity(MedicalRecordRequestDTO medicalRecordRequestDTO) {
        MedicalRecordEntity medicalRecordEntity = new MedicalRecordEntity();
        medicalRecordEntity.setUuid(medicalRecordRequestDTO.getUuid());
        medicalRecordEntity.setId(medicalRecordRequestDTO.getId());
        medicalRecordEntity.setDoctor(doctorMapper.dtoToEntity(medicalRecordRequestDTO.getDoctor()));
        medicalRecordEntity.setPatient(patientMapper.dtoToEntity(medicalRecordRequestDTO.getPatient()));
        medicalRecordEntity.setExaminationNotes(medicalRecordRequestDTO.getExaminationNotes());
        medicalRecordEntity.setExaminationDateTime(medicalRecordRequestDTO.getExaminationDateTime());


        return medicalRecordEntity;
    }

    @Override
    public List<MedicalRecordEntity> requestDTOListToEntityList(List<MedicalRecordRequestDTO> medicalRecordRequestDTOS) {
        List<MedicalRecordEntity> medicalRecordEntityList = new ArrayList<>();
        for (MedicalRecordRequestDTO medicalRecordRequestDTO : medicalRecordRequestDTOS) {
            medicalRecordEntityList.add(requestDTOToEntity(medicalRecordRequestDTO));
        }
        return medicalRecordEntityList;
    }

    @Override
    public MedicalRecordEntity requestDTOToExistEntity(MedicalRecordRequestDTO medicalRecordRequestDTO, MedicalRecordEntity medicalRecordEntity) {
        medicalRecordEntity.setCreationDate(medicalRecordRequestDTO.getCreationDate());
        medicalRecordEntity.setUpdatedDate(medicalRecordRequestDTO.getUpdatedDate());
        medicalRecordEntity.setId(medicalRecordRequestDTO.getId());
        medicalRecordEntity.setUuid(medicalRecordRequestDTO.getUuid());
        medicalRecordEntity.setDoctor(doctorMapper.dtoToEntity(medicalRecordRequestDTO.getDoctor()));
        medicalRecordEntity.setPatient(patientMapper.dtoToEntity(medicalRecordRequestDTO.getPatient()));
        medicalRecordEntity.setExaminationNotes(medicalRecordRequestDTO.getExaminationNotes());
        medicalRecordEntity.setExaminationDateTime(medicalRecordRequestDTO.getExaminationDateTime());
        return medicalRecordEntity;


    }


}
