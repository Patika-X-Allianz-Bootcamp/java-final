package Tourism.mapper;

import Tourism.database.entity.PatientEntity;
import Tourism.model.PatientDTO;
import Tourism.model.requestDTO.PageDTO;
import Tourism.model.requestDTO.RequestPatientDTO;
import Tourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper implements IBaseMapper<PatientDTO, PatientEntity, RequestPatientDTO> {

    @Autowired
    @Lazy
    HospitalMapper hospitalMapper;

    @Autowired
    @Lazy
    HotelMapper hotelMapper;

    @Autowired
    @Lazy
    FlightMapper flightMapper;

    @Autowired
    @Lazy
    AppointmentMapper appointmentMapper;

    @Override
    public PatientDTO entityToDTO(PatientEntity entity) {
        PatientDTO dto = new PatientDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAge(entity.getAge());
        dto.setIllness(entity.getIllness());
        dto.setSex(entity.getSex());
        dto.setSymptomList(entity.getSymptomList());
        dto.setReport(entity.getReport());
        dto.setHasAppointment(entity.isHasAppointment());
        if(entity.getAccommodation()!=null){
            dto.setAccommodation(hotelMapper.entityToDTO(entity.getAccommodation()));
        }
        if(entity.getFlight()!=null){
            dto.setFlight(flightMapper.entityToDTO(entity.getFlight()));
        }
        if(entity.getHospital()!=null){
            dto.setHospital(hospitalMapper.entityToDTO(entity.getHospital()));
        }
        if (entity.getAppointmentList() != null) {
            dto.setAppointmentList(appointmentMapper.entityListToDTOList(entity.getAppointmentList()));
        }
        return dto;
    }

    @Override
    public PatientEntity dtoToEntity(PatientDTO dto) {
        PatientEntity entity = new PatientEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setIllness(dto.getIllness());
        entity.setSex(dto.getSex());
        entity.setSymptomList(dto.getSymptomList());
        entity.setReport(dto.getReport());
        entity.setHasAppointment(dto.isHasAppointment());
        if(dto.getAccommodation()!=null){
            entity.setAccommodation(hotelMapper.dtoToEntity(dto.getAccommodation()));
        }
        if(dto.getFlight()!=null){
            entity.setFlight(flightMapper.dtoToEntity(dto.getFlight()));
        }
        if(dto.getHospital()!=null){
            entity.setHospital(hospitalMapper.dtoToEntity(dto.getHospital()));
        }
        if (dto.getAppointmentList() != null) {
            entity.setAppointmentList(appointmentMapper.dtoListTOEntityList(dto.getAppointmentList()));
        }
        return entity;

    }

    @Override
    public List<PatientDTO> entityListToDTOList(List<PatientEntity> patientEntities) {
        List<PatientDTO> dtoList = new ArrayList<>();
        for (PatientEntity entity : patientEntities) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<PatientEntity> dtoListTOEntityList(List<PatientDTO> patientDTOS) {
        List<PatientEntity> entityList = new ArrayList<>();
        for (PatientDTO dto : patientDTOS) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public PatientEntity requestDTOToEntity(RequestPatientDTO dto) {
        PatientEntity entity = new PatientEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setIllness(dto.getIllness());
        entity.setSex(dto.getSex());
        entity.setSymptomList(dto.getSymptomList());
        entity.setReport(dto.getReport());
        entity.setHasAppointment(dto.isHasAppointment());
        if(dto.getAccommodation()!=null){
            entity.setAccommodation(hotelMapper.requestDTOToEntity(dto.getAccommodation()));
        }
        if(dto.getFlight()!=null){
            entity.setFlight(flightMapper.requestDTOToEntity(dto.getFlight()));
        }
        if(dto.getHospital()!=null){
            entity.setHospital(hospitalMapper.requestDTOToEntity(dto.getHospital()));
        }
        if (dto.getAppointmentList() != null) {
            entity.setAppointmentList(appointmentMapper.requestDtoListTOEntityList(dto.getAppointmentList()));
        }
        return entity;
    }

    @Override
    public List<PatientEntity> requestDtoListTOEntityList(List<RequestPatientDTO> requestPatientDTOS) {
        List<PatientEntity> entityList = new ArrayList<>();
        for (RequestPatientDTO dto : requestPatientDTOS) {
            entityList.add(requestDTOToEntity(dto));
        }
        return entityList;
    }

    @Override
    public PatientEntity requestDtoToExistEntity(PatientEntity entity, RequestPatientDTO requestPatientDTO) {
        entity.setName(requestPatientDTO.getName());
        entity.setSurname(requestPatientDTO.getSurname());
        entity.setAge(requestPatientDTO.getAge());
        entity.setIllness(requestPatientDTO.getIllness());
        entity.setSex(requestPatientDTO.getSex());
        entity.setSymptomList(requestPatientDTO.getSymptomList());
        entity.setReport(requestPatientDTO.getReport());
        entity.setHasAppointment(requestPatientDTO.isHasAppointment());
        if(requestPatientDTO.getAccommodation()!=null){
            entity.setAccommodation(hotelMapper.requestDTOToEntity(requestPatientDTO.getAccommodation()));
        }
        if(requestPatientDTO.getFlight()!=null){
            entity.setFlight(flightMapper.requestDTOToEntity(requestPatientDTO.getFlight()));
        }
        if(requestPatientDTO.getHospital()!=null){
            entity.setHospital(hospitalMapper.requestDTOToEntity(requestPatientDTO.getHospital()));
        }
        if (requestPatientDTO.getAppointmentList() != null) {
            entity.setAppointmentList(appointmentMapper.requestDtoListTOEntityList(requestPatientDTO.getAppointmentList()));
        }
        return entity;
    }

    @Override
    public PageDTO<PatientDTO> pageEntityToPageDTO(Page<PatientEntity> entityPage) {
        PageDTO<PatientDTO> dtoPage = new PageDTO<>();
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
