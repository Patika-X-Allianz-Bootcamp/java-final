package patika.fhw.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import patika.fhw.demo.database.entity.Hospital;
import patika.fhw.demo.model.dto.HospitalDTO;
import patika.fhw.demo.model.requestDTO.HospitalRequestDTO;
import patika.fhw.demo.model.requestDTO.PageDTO;
import patika.fhw.demo.util.BaseMapper;

@Component
public class HospitalMapper implements BaseMapper<HospitalDTO, Hospital, HospitalRequestDTO> {

    @Override
    public HospitalDTO entityToDTO(Hospital entity) {
        HospitalDTO dto = new HospitalDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        dto.setPhone(entity.getContactNumber());
        return dto;
    }

    @Override
    public Hospital dtoToEntity(HospitalDTO dto) {
        Hospital entity = new Hospital();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        entity.setContactNumber(dto.getPhone());
        return entity;
    }

    @Override
    public List<HospitalDTO> entityListToDTOList(List<Hospital> entityList) {
        List<HospitalDTO> dtoList = new ArrayList<>();
        for (Hospital entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<Hospital> dtoListTOEntityList(List<HospitalDTO> dtoList) {
        List<Hospital> entityList = new ArrayList<>();
        for (HospitalDTO dto : dtoList) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public Hospital requestDTOToEntity(HospitalRequestDTO dto) {
        Hospital entity = new Hospital();
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        entity.setContactNumber(dto.getContact());
        return entity;
    }

    @Override
    public List<Hospital> requestDtoListTOEntityList(List<HospitalRequestDTO> dtoList) {
        List<Hospital> entityList = new ArrayList<>();
        for (HospitalRequestDTO dto : dtoList) {
            entityList.add(requestDTOToEntity(dto));
        }
        return entityList;
    }

    @Override
    public Hospital requestDtoToExistEntity(Hospital entity, HospitalRequestDTO requestDTO) {
        entity.setName(requestDTO.getName());
        entity.setLocation(requestDTO.getLocation());
        entity.setContactNumber(requestDTO.getContact());
        return entity;
    }

    @Override
    public PageDTO<HospitalDTO> pageEntityToPageDTO(Page<Hospital> entityPage) {
        PageDTO<HospitalDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(entityListToDTOList(entityPage.getContent()));
        pageDTO.setTotalPages(entityPage.getTotalPages());
        pageDTO.setTotalElements(entityPage.getTotalElements());
        pageDTO.setCurrentPage(entityPage.getNumber());
        pageDTO.setSize(entityPage.getSize());
        return pageDTO;
    }
}
