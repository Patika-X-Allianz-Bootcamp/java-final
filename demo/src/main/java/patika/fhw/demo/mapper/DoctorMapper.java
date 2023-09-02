package patika.fhw.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import patika.fhw.demo.database.entity.Doctor;
import patika.fhw.demo.model.dto.DoctorDTO;
import patika.fhw.demo.model.requestDTO.DoctorRequestDTO;
import patika.fhw.demo.model.requestDTO.PageDTO;
import patika.fhw.demo.util.BaseMapper;

public class DoctorMapper implements BaseMapper<DoctorDTO, Doctor, DoctorRequestDTO> {

    @Override
    public DoctorDTO entityToDTO(Doctor entity) {
        DoctorDTO dto = new DoctorDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setSpecialty(entity.getSpecialty());
        return dto;
    }

    @Override
    public Doctor dtoToEntity(DoctorDTO dto) {
        Doctor entity = new Doctor();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSpecialty(dto.getSpecialty());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<Doctor> entityList) {
        List<DoctorDTO> dtoList = new ArrayList<>();
        for (Doctor entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<Doctor> dtoListTOEntityList(List<DoctorDTO> dtoList) {
        List<Doctor> entityList = new ArrayList<>();
        for (DoctorDTO dto : dtoList) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public Doctor requestDTOToEntity(DoctorRequestDTO dto) {
        Doctor entity = new Doctor();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSpecialty(dto.getSpecialty());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    @Override
    public List<Doctor> requestDtoListTOEntityList(List<DoctorRequestDTO> dtoList) {
        List<Doctor> entityList = new ArrayList<>();
        for (DoctorRequestDTO dto : dtoList) {
            entityList.add(requestDTOToEntity(dto));
        }
        return entityList;
    }

    @Override
    public Doctor requestDtoToExistEntity(Doctor entity, DoctorRequestDTO requestDTO) {
        entity.setFirstName(requestDTO.getFirstName());
        entity.setLastName(requestDTO.getLastName());
        entity.setSpecialty(requestDTO.getSpecialty());
        entity.setEmail(requestDTO.getEmail());
        entity.setPassword(requestDTO.getPassword());
        return entity;
    }

    @Override
    public PageDTO<DoctorDTO> pageEntityToPageDTO(Page<Doctor> entityPage) {
        List<DoctorDTO> dtoList = entityListToDTOList(entityPage.getContent());
        PageDTO<DoctorDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(dtoList);
        pageDTO.setTotalPages(entityPage.getTotalPages());
        pageDTO.setTotalElements(entityPage.getTotalElements());
        pageDTO.setCurrentPage(entityPage.getNumber());
        pageDTO.setSize(entityPage.getSize());
        return pageDTO;
    }
}
