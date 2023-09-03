package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.PrescriptionEntity;
import com.tourismcorp.healthtourism.model.PrescriptionDTO;
import com.tourismcorp.healthtourism.model.requestDTO.PrescriptionRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrescriptionMapper implements IBaseMapper<PrescriptionEntity, PrescriptionDTO, PrescriptionRequestDTO> {

    private final DoctorMapper doctorMapper;

    @Autowired
    protected PrescriptionMapper(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }
    @Override
    public PrescriptionDTO entityToDTO(PrescriptionEntity entity) {
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setUuid(entity.getUuid());
        prescriptionDTO.setCreationDate(entity.getCreationDate());
        prescriptionDTO.setUpdatedDate(entity.getUpdatedDate());
        prescriptionDTO.setId(entity.getId());
        prescriptionDTO.setDoctor(doctorMapper.entityToDTO(entity.getDoctor()));
        prescriptionDTO.setPrescription(entity.getPrescription());

        return prescriptionDTO;
    }

    @Override
    public PrescriptionEntity dtoToEntity(PrescriptionDTO dto) {
        PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
        prescriptionEntity.setUuid(dto.getUuid());
        prescriptionEntity.setCreationDate(dto.getCreationDate());
        prescriptionEntity.setUpdatedDate(dto.getUpdatedDate());
        prescriptionEntity.setId(dto.getId());
        prescriptionEntity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        prescriptionEntity.setPrescription(dto.getPrescription());

        return prescriptionEntity;
    }

    @Override
    public List<PrescriptionDTO> entityListToDTOList(List<PrescriptionEntity> entityList) {
        List<PrescriptionDTO> prescriptionDTOList = new ArrayList<>();
        for (PrescriptionEntity entity : entityList) {
            PrescriptionDTO dto = entityToDTO(entity);
            prescriptionDTOList.add(dto);
        }
        return prescriptionDTOList;
    }

    @Override
    public List<PrescriptionEntity> dtoListToEntityList(List<PrescriptionDTO> dtoList) {
        List<PrescriptionEntity> prescriptionEntityList = new ArrayList<>();
        for (PrescriptionDTO dto : dtoList) {
            PrescriptionEntity entity = dtoToEntity(dto);
            prescriptionEntityList.add(entity);
        }
        return prescriptionEntityList;
    }

    @Override
    public PrescriptionEntity requestDTOToEntity(PrescriptionRequestDTO requestDTO) {
        PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
        prescriptionEntity.setUuid(requestDTO.getUuid());
        prescriptionEntity.setCreationDate(requestDTO.getCreationDate());
        prescriptionEntity.setUpdatedDate(requestDTO.getUpdatedDate());
        prescriptionEntity.setId(requestDTO.getId());
        prescriptionEntity.setDoctor(doctorMapper.requestDTOToEntity(requestDTO.getDoctor()));
        prescriptionEntity.setPrescription(requestDTO.getPrescription());

        return prescriptionEntity;
    }

    @Override
    public List<PrescriptionEntity> requestDTOListToEntityList(List<PrescriptionRequestDTO> dtoList) {
        List<PrescriptionEntity> prescriptionEntityList = new ArrayList<>();
        for (PrescriptionRequestDTO dto : dtoList) {
            PrescriptionEntity entity = requestDTOToEntity(dto);
            prescriptionEntityList.add(entity);
        }
        return prescriptionEntityList;
    }

    @Override
    public PrescriptionEntity requestDTOToExistEntity(PrescriptionRequestDTO requestDTO, PrescriptionEntity entity) {
        if (requestDTO.getDoctor() != null)
            entity.setDoctor(doctorMapper.requestDTOToEntity(requestDTO.getDoctor()));
        if (requestDTO.getPrescription() != null)
            entity.setPrescription(requestDTO.getPrescription());

        return entity;
    }

    @Override
    public Page<PrescriptionDTO> pageEntityToPageDTO(Page<PrescriptionEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
