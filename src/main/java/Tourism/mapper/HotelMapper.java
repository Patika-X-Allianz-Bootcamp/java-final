package Tourism.mapper;

import Tourism.database.entity.DoctorEntity;
import Tourism.database.entity.HotelEntity;
import Tourism.model.DoctorDTO;
import Tourism.model.HotelDTO;
import Tourism.model.requestDTO.PageDTO;
import Tourism.model.requestDTO.RequestHotelDTO;
import Tourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelMapper implements IBaseMapper<HotelDTO, HotelEntity, RequestHotelDTO> {

    @Autowired
    @Lazy
    PatientMapper patientMapper;

    @Override
    public HotelDTO entityToDTO(HotelEntity entity) {
        HotelDTO dto = new HotelDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        dto.setWebsite(entity.getWebsite());
        dto.setStarRating(entity.getStarRating());
        dto.setRoomCapacity(entity.getRoomCapacity());
        dto.setPetFriendly(entity.isPetFriendly());
        dto.setDescription(entity.getDescription());
        if(entity.getPatientList()!=null){
            dto.setPatientList(patientMapper.entityListToDTOList(entity.getPatientList()));
        }

        return dto;
    }

    @Override
    public HotelEntity dtoToEntity(HotelDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setWebsite(dto.getWebsite());
        entity.setStarRating(dto.getStarRating());
        entity.setRoomCapacity(dto.getRoomCapacity());
        entity.setPetFriendly(dto.isPetFriendly());
        entity.setDescription(dto.getDescription());
        if(dto.getPatientList()!=null){
            entity.setPatientList(patientMapper.dtoListTOEntityList(dto.getPatientList()));
        }
        return entity;
    }

    @Override
    public List<HotelDTO> entityListToDTOList(List<HotelEntity> hotelEntities) {
        List<HotelDTO> dtoList = new ArrayList<>();
        for (HotelEntity entity : hotelEntities) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<HotelEntity> dtoListTOEntityList(List<HotelDTO> hotelDTOS) {
        List<HotelEntity> entityList = new ArrayList<>();
        for (HotelDTO dto : hotelDTOS) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public HotelEntity requestDTOToEntity(RequestHotelDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setWebsite(dto.getWebsite());
        entity.setStarRating(dto.getStarRating());
        entity.setRoomCapacity(dto.getRoomCapacity());
        entity.setPetFriendly(dto.isPetFriendly());
        entity.setDescription(dto.getDescription());
        if(dto.getPatientList()!=null){
            entity.setPatientList(patientMapper.requestDtoListTOEntityList(dto.getPatientList()));
        }
        return entity;
    }

    @Override
    public List<HotelEntity> requestDtoListTOEntityList(List<RequestHotelDTO> requestHotelDTOS) {
        List<HotelEntity> entityList = new ArrayList<>();
        for (RequestHotelDTO dto : requestHotelDTOS) {
            entityList.add(requestDTOToEntity(dto));
        }
        return entityList;
    }

    @Override
    public HotelEntity requestDtoToExistEntity(HotelEntity entity, RequestHotelDTO requestHotelDTO) {
        entity.setName(requestHotelDTO.getName());
        entity.setAddress(requestHotelDTO.getAddress());
        entity.setPhoneNumber(requestHotelDTO.getPhoneNumber());
        entity.setEmail(requestHotelDTO.getEmail());
        entity.setWebsite(requestHotelDTO.getWebsite());
        entity.setStarRating(requestHotelDTO.getStarRating());
        entity.setRoomCapacity(requestHotelDTO.getRoomCapacity());
        entity.setPetFriendly(requestHotelDTO.isPetFriendly());
        entity.setDescription(requestHotelDTO.getDescription());
        return entity;
    }

    @Override
    public PageDTO<HotelDTO> pageEntityToPageDTO(Page<HotelEntity> entityPage) {
        PageDTO<HotelDTO> dtoPage = new PageDTO<>();
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
