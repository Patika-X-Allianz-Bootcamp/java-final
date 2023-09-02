package patika.fhw.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import patika.fhw.demo.database.entity.Appointment;
import patika.fhw.demo.model.dto.AppointmentDTO;
import patika.fhw.demo.model.requestDTO.AppointmentRequestDTO;
import patika.fhw.demo.model.requestDTO.PageDTO;
import patika.fhw.demo.util.BaseMapper;

@Component
public class AppointmentMapper implements BaseMapper<AppointmentDTO, Appointment, AppointmentRequestDTO> {

    @Override
    public AppointmentDTO entityToDTO(Appointment entity) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(entity.getId());
        dto.setAppointmentDate(entity.getAppointmentDate());
        return dto;
    }

    @Override
    public Appointment dtoToEntity(AppointmentDTO dto) {
        Appointment entity = new Appointment();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public List<AppointmentDTO> entityListToDTOList(List<Appointment> entityList) {
        return entityList.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Appointment> dtoListTOEntityList(List<AppointmentDTO> dtoList) {
        return dtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public Appointment requestDTOToEntity(AppointmentRequestDTO dto) {
        Appointment entity = new Appointment();
        return entity;
    }

    @Override
    public List<Appointment> requestDtoListTOEntityList(List<AppointmentRequestDTO> dtoList) {
        return dtoList.stream().map(this::requestDTOToEntity).collect(Collectors.toList());
    }

    @Override
    public Appointment requestDtoToExistEntity(Appointment entity, AppointmentRequestDTO requestDTO) {
        return entity;
    }

    @Override
    public PageDTO<AppointmentDTO> pageEntityToPageDTO(Page<Appointment> entityPage) {
        PageDTO<AppointmentDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(entityPage.getContent().stream().map(this::entityToDTO).collect(Collectors.toList()));
        pageDTO.setTotalPages(entityPage.getTotalPages());
        pageDTO.setTotalElements(entityPage.getTotalElements());
        pageDTO.setCurrentPage(entityPage.getNumber());
        pageDTO.setSize(entityPage.getSize());
        return pageDTO;
    }
}
