package Tourism.mapper;

import Tourism.database.entity.AppointmentEntity;
import Tourism.database.entity.DoctorEntity;
import Tourism.model.AppointmentDTO;
import Tourism.model.DoctorDTO;
import Tourism.model.requestDTO.PageDTO;
import Tourism.model.requestDTO.RequestAppointmentDTO;
import Tourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapper implements IBaseMapper<AppointmentDTO, AppointmentEntity, RequestAppointmentDTO> {

    //liste
    @Autowired
    @Lazy
    DoctorMapper doctorMapper;

    @Autowired
    @Lazy
    PatientMapper patientMapper;

    @Override
    public AppointmentDTO entityToDTO(AppointmentEntity entity) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setAppoinmentDate(entity.getAppointmentDate());
        dto.setDuration(entity.getDuration());
        if(entity.getDoctor()!=null){
            dto.setDoctor(doctorMapper.entityToDTO(entity.getDoctor()));
        }
        if(entity.getPatient()!=null){
            dto.setPatient(patientMapper.entityToDTO(entity.getPatient()));
        }
        return dto;
    }

    @Override
    public AppointmentEntity dtoToEntity(AppointmentDTO dto) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setAppointmentDate(dto.getAppoinmentDate());
        entity.setDuration(dto.getDuration());
        if(dto.getDoctor()!=null){
            entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        }
        if(dto.getPatient()!=null){
            entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        }
        return entity;
    }

    @Override
    public List<AppointmentDTO> entityListToDTOList(List<AppointmentEntity> entityList) {
        List<AppointmentDTO> dtoList = new ArrayList<>();
        for (AppointmentEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<AppointmentEntity> dtoListTOEntityList(List<AppointmentDTO> dtoList) {
        List<AppointmentEntity> entityList = new ArrayList<>();
        for (AppointmentDTO dto : dtoList) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public AppointmentEntity requestDTOToEntity(RequestAppointmentDTO dto) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setAppointmentDate(dto.getAppoinmentDate());
        entity.setDuration(dto.getDuration());
        if(dto.getDoctor()!=null){
            entity.setDoctor(doctorMapper.requestDTOToEntity(dto.getDoctor()));
        }
        if(dto.getPatient()!=null){
            entity.setPatient(patientMapper.requestDTOToEntity(dto.getPatient()));
        }
        return entity;
    }

    @Override
    public List<AppointmentEntity> requestDtoListTOEntityList(List<RequestAppointmentDTO> dtoList) {
        List<AppointmentEntity> entityList = new ArrayList<>();
        for (RequestAppointmentDTO dto : dtoList) {
            entityList.add(requestDTOToEntity(dto));
        }
        return entityList;
    }

    @Override
    public AppointmentEntity requestDtoToExistEntity(AppointmentEntity entity, RequestAppointmentDTO dto) {
        entity.setAppointmentDate(dto.getAppoinmentDate());
        entity.setDuration(dto.getDuration());
        if(dto.getDoctor()!=null){
            entity.setDoctor(doctorMapper.requestDTOToEntity(dto.getDoctor()));
        }
        if(dto.getPatient()!=null){
            entity.setPatient(patientMapper.requestDTOToEntity(dto.getPatient()));
        }
        return entity;
    }

    @Override
    public PageDTO<AppointmentDTO> pageEntityToPageDTO(Page<AppointmentEntity> entityPage) {
        PageDTO<AppointmentDTO> dtoPage = new PageDTO<>();
        dtoPage.setTotalPages(entityPage.getTotalPages());
        dtoPage.setTotalElements(entityPage.getTotalElements());
        dtoPage.setSort(entityPage.getSort());
        dtoPage.setSize(entityPage.getSize());
        dtoPage.setNumber(entityPage.getNumber());
        dtoPage.setContent(entityListToDTOList(entityPage.getContent()));
        dtoPage.setHasContent(entityPage.hasContent());

        return dtoPage;
    }
}
