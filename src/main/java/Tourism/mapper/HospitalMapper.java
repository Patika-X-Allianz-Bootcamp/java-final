package Tourism.mapper;

import Tourism.database.entity.HospitalEntity;
import Tourism.model.HospitalDTO;
import Tourism.model.requestDTO.PageDTO;
import Tourism.model.requestDTO.RequestHospitalDTO;
import Tourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class HospitalMapper implements IBaseMapper<HospitalDTO, HospitalEntity, RequestHospitalDTO> {

    @Autowired
    @Lazy
    PatientMapper patientMapper;
    @Autowired
    @Lazy
    DoctorMapper doctorMapper;


    @Override
    public HospitalDTO entityToDTO(HospitalEntity entity) {

        HospitalDTO dto = new HospitalDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        dto.setWebsite(entity.getWebsite());
        dto.setDescription(entity.getDescription());
        dto.setNumberOfBeds(entity.getNumberOfBeds());
        dto.setNumberOfDoctors(entity.getNumberOfDoctors());
        dto.setClinics(entity.getClinics());
        if(entity.getPatientList()!=null){
            dto.setPatientList(patientMapper.entityListToDTOList(entity.getPatientList()));
        }
        if(entity.getDoctorList()!=null){
            dto.setDoctorList(doctorMapper.entityListToDTOList(entity.getDoctorList()));
        }

        return dto;
    }

    @Override
    public HospitalEntity dtoToEntity(HospitalDTO dto) {
        HospitalEntity entity = new HospitalEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setWebsite(dto.getWebsite());
        entity.setDescription(dto.getDescription());
        entity.setNumberOfBeds(dto.getNumberOfBeds());
        entity.setNumberOfDoctors(dto.getNumberOfDoctors());
        entity.setClinics(dto.getClinics());
        // Mapping the doctor list is omitted here, you can add it similarly to DoctorMapper
        if(dto.getPatientList()!=null){
            entity.setPatientList(patientMapper.dtoListTOEntityList(dto.getPatientList()));
        }
        if(dto.getDoctorList()!=null){
            entity.setDoctorList(doctorMapper.dtoListTOEntityList(dto.getDoctorList()));
        }
        return entity;
    }

    @Override
    public List<HospitalDTO> entityListToDTOList(List<HospitalEntity> hospitalEntities) {
        List<HospitalDTO> dtoList = new ArrayList<>();
        for (HospitalEntity entity : hospitalEntities) {
            HospitalDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }


    @Override
    public List<HospitalEntity> dtoListTOEntityList(List<HospitalDTO> hospitalDTOS) {
        List<HospitalEntity> entityList = new ArrayList<>();
        for (HospitalDTO dto : hospitalDTOS) {
            HospitalEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public HospitalEntity requestDTOToEntity(RequestHospitalDTO dto) {
        HospitalEntity entity = new HospitalEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setWebsite(dto.getWebsite());
        entity.setDescription(dto.getDescription());
        entity.setNumberOfBeds(dto.getNumberOfBeds());
        entity.setNumberOfDoctors(dto.getNumberOfDoctors());
        entity.setClinics(dto.getClinics());
        if(dto.getPatientList()!=null){
            entity.setPatientList(patientMapper.requestDtoListTOEntityList(dto.getPatientList()));
        }
        if(dto.getDoctorList()!=null){
            entity.setDoctorList(doctorMapper.requestDtoListTOEntityList(dto.getDoctorList()));
        }

        return entity;    }

    @Override
    public List<HospitalEntity> requestDtoListTOEntityList(List<RequestHospitalDTO> requestHospitalDTOS) {
        return null;
    }

    @Override
    public HospitalEntity requestDtoToExistEntity(HospitalEntity entity, RequestHospitalDTO requestHospitalDTO) {
        entity.setName(requestHospitalDTO.getName());
        entity.setAddress(requestHospitalDTO.getAddress());
        entity.setPhoneNumber(requestHospitalDTO.getPhoneNumber());
        entity.setEmail(requestHospitalDTO.getEmail());
        entity.setWebsite(requestHospitalDTO.getWebsite());
        entity.setDescription(requestHospitalDTO.getDescription());
        entity.setNumberOfBeds(requestHospitalDTO.getNumberOfBeds());
        entity.setNumberOfDoctors(requestHospitalDTO.getNumberOfDoctors());
        entity.setClinics(requestHospitalDTO.getClinics());
        // Mapping the doctor list is omitted here, you can add it similarly to DoctorMapper
        if(requestHospitalDTO.getPatientList()!=null){
            entity.setPatientList(patientMapper.requestDtoListTOEntityList(requestHospitalDTO.getPatientList()));
        }
        if(requestHospitalDTO.getDoctorList()!=null){
            entity.setDoctorList(doctorMapper.requestDtoListTOEntityList(requestHospitalDTO.getDoctorList()));
        }
        return entity;
    }

    @Override
    public PageDTO<HospitalDTO> pageEntityToPageDTO(Page<HospitalEntity> entityPage) {
        PageDTO<HospitalDTO> dtoPage = new PageDTO<>();
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
