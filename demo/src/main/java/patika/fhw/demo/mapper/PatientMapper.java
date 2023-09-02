package patika.fhw.demo.mapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import patika.fhw.demo.database.entity.Patient;
import patika.fhw.demo.model.dto.PatientDTO;
import patika.fhw.demo.model.requestDTO.PageDTO;
import patika.fhw.demo.model.requestDTO.PatientRequestDTO;
import patika.fhw.demo.util.BaseMapper;

@Component
public class PatientMapper implements BaseMapper<PatientDTO, Patient, PatientRequestDTO> {

    @Override
    public PatientDTO entityToDTO(Patient entity) {
        PatientDTO dto = new PatientDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBirthDate(entity.getDateOfBirth());
        dto.setEmail(entity.getEmail());
        dto.setNationality(entity.getNationality());
        dto.setPhone("123-456-7890");
        dto.setPassword(null);
        return dto;
    }

    @Override
    public Patient dtoToEntity(PatientDTO dto) {
        Patient entity = new Patient();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDateOfBirth(dto.getBirthDate());
        entity.setEmail(dto.getEmail());
        entity.setNationality(dto.getNationality());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    @Override
    public List<PatientDTO> entityListToDTOList(List<Patient> entityList) {
        return entityList.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Patient> dtoListTOEntityList(List<PatientDTO> dtoList) {
        return dtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public Patient requestDTOToEntity(PatientRequestDTO dto) {
        Patient entity = new Patient();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDateOfBirth(dto.getBirthDate());
        entity.setEmail(dto.getEmail());
        entity.setNationality(dto.getNationality());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    @Override
    public List<Patient> requestDtoListTOEntityList(List<PatientRequestDTO> dtoList) {
        return dtoList.stream().map(this::requestDTOToEntity).collect(Collectors.toList());
    }

    @Override
    public Patient requestDtoToExistEntity(Patient entity, PatientRequestDTO requestDTO) {
        entity.setFirstName(requestDTO.getFirstName());
        entity.setLastName(requestDTO.getLastName());
        entity.setDateOfBirth(requestDTO.getBirthDate());
        entity.setEmail(requestDTO.getEmail());
        entity.setNationality(requestDTO.getNationality());
        entity.setPassword(requestDTO.getPassword());
        return entity;
    }

    @Override
    public PageDTO<PatientDTO> pageEntityToPageDTO(Page<Patient> entityPage) {
        PageDTO<PatientDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(entityPage.getContent().stream().map(this::entityToDTO).collect(Collectors.toList()));
        pageDTO.setTotalPages(entityPage.getTotalPages());
        pageDTO.setTotalElements(entityPage.getTotalElements());
        pageDTO.setCurrentPage(entityPage.getNumber());
        pageDTO.setSize(entityPage.getSize());
        return pageDTO;
    }
}


