package Tourism.mapper;

import Tourism.database.entity.DoctorEntity;
import Tourism.model.DoctorDTO;
import Tourism.model.requestDTO.PageDTO;
import Tourism.model.requestDTO.RequestDoctorDTO;

import Tourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper implements IBaseMapper<DoctorDTO, DoctorEntity, RequestDoctorDTO> {

    @Autowired
    @Lazy
    HospitalMapper hospitalMapper;

    @Autowired
    @Lazy
    AppointmentMapper appointmentMapper;

    @Override
    public DoctorDTO entityToDTO(DoctorEntity entity) {
        DoctorDTO dto = new DoctorDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAge(entity.getAge());
        dto.setExpertise(entity.getExpertise());
        dto.setTitle(entity.getTitle());
        dto.setSex(entity.getSex());
        dto.setOperationDay(entity.isOperationDay());
        dto.setAppointmentCapacity(entity.getAppointmentCapacity());
        if(entity.getHospital()!=null){
            dto.setHospital(hospitalMapper.entityToDTO(entity.getHospital()));
        }
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        if(entity.getAppointmentList()!=null){
            dto.setAppointmentList(appointmentMapper.entityListToDTOList(entity.getAppointmentList()));
        }
        return dto;
    }

    @Override
    public DoctorEntity dtoToEntity(DoctorDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setExpertise(dto.getExpertise());
        entity.setTitle(dto.getTitle());
        entity.setSex(dto.getSex());
        entity.setOperationDay(dto.isOperationDay());
        entity.setAppointmentCapacity(dto.getAppointmentCapacity());
        if(dto.getHospital()!=null){
            entity.setHospital(hospitalMapper.dtoToEntity(dto.getHospital()));
        }
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        if(entity.getAppointmentList()!=null){
            entity.setAppointmentList(appointmentMapper.dtoListTOEntityList(dto.getAppointmentList()));
        }
        return entity;
    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<DoctorEntity> doctorEntities) {
        List<DoctorDTO> dtoList = new ArrayList<>();
        for (DoctorEntity entity : doctorEntities) {
            DoctorDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<DoctorEntity> dtoListTOEntityList(List<DoctorDTO> doctorDTOS) {
        List<DoctorEntity> entityList = new ArrayList<>();
        for (DoctorDTO dto : doctorDTOS) {
            DoctorEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }

        return entityList;
    }


    @Override
    public DoctorEntity requestDTOToEntity(RequestDoctorDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setExpertise(dto.getExpertise());
        entity.setTitle(dto.getTitle());
        entity.setSex(dto.getSex());
        entity.setOperationDay(dto.isOperationDay());
        entity.setAppointmentCapacity(dto.getAppointmentCapacity());
        if(dto.getHospital()!=null){
            entity.setHospital(hospitalMapper.requestDTOToEntity(dto.getHospital()));
        }
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        if(entity.getAppointmentList()!=null){
            entity.setAppointmentList(appointmentMapper.requestDtoListTOEntityList(dto.getAppointmentList()));
        }

        return entity;
    }

    @Override
    public List<DoctorEntity> requestDtoListTOEntityList(List<RequestDoctorDTO> requestDoctorEntityList) {
        return null;
    }

    @Override
    public DoctorEntity requestDtoToExistEntity(DoctorEntity entity, RequestDoctorDTO dto) {
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setExpertise(dto.getExpertise());
        entity.setTitle(dto.getTitle());
        entity.setSex(dto.getSex());
        entity.setOperationDay(dto.isOperationDay());
        entity.setAppointmentCapacity(dto.getAppointmentCapacity());
        if(dto.getHospital()!=null){
            entity.setHospital(hospitalMapper.requestDTOToEntity(dto.getHospital()));
        }
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        if(entity.getAppointmentList()!=null){
            entity.setAppointmentList(appointmentMapper.requestDtoListTOEntityList(dto.getAppointmentList()));
        }
        //liste

        return entity;

    }

    @Override
    public PageDTO<DoctorDTO> pageEntityToPageDTO(Page<DoctorEntity> entityPage) {
        PageDTO<DoctorDTO> dtoPage = new PageDTO<>();
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
