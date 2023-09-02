package patika.fhw.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import patika.fhw.demo.database.entity.Hotel;
import patika.fhw.demo.model.dto.HotelDTO;
import patika.fhw.demo.model.requestDTO.HotelRequestDTO;
import patika.fhw.demo.model.requestDTO.PageDTO;
import patika.fhw.demo.util.BaseMapper;

@Component
public class HotelMapper implements BaseMapper<HotelDTO, Hotel, HotelRequestDTO> {

    @Override
    public HotelDTO entityToDTO(Hotel entity) {
        HotelDTO dto = new HotelDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        dto.setStarRating(entity.getStarRating());
        return dto;
    }

    @Override
    public Hotel dtoToEntity(HotelDTO dto) {
        Hotel entity = new Hotel();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLocation(dto.getLocation());
        entity.setStarRating(dto.getStarRating());
        return entity;
    }

    @Override
    public List<HotelDTO> entityListToDTOList(List<Hotel> entityList) {
        List<HotelDTO> dtoList = new ArrayList<>();
        for (Hotel entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<Hotel> dtoListTOEntityList(List<HotelDTO> dtoList) {
        List<Hotel> entityList = new ArrayList<>();
        for (HotelDTO dto : dtoList) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public Hotel requestDTOToEntity(HotelRequestDTO requestDTO) {
        Hotel entity = new Hotel();
        entity.setName(requestDTO.getName());
        entity.setLocation(requestDTO.getLocation());
        entity.setStarRating(requestDTO.getStarRating());
        return entity;
    }

    @Override
    public List<Hotel> requestDtoListTOEntityList(List<HotelRequestDTO> dtoList) {
        return dtoList.stream()
                .map(this::requestDTOToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Hotel requestDtoToExistEntity(Hotel entity, HotelRequestDTO requestDTO) {
        if (requestDTO.getName() != null) {
            entity.setName(requestDTO.getName());
        }
        if (requestDTO.getLocation() != null) {
            entity.setLocation(requestDTO.getLocation());
        }
        if (requestDTO.getStarRating() != 0) {
            entity.setStarRating(requestDTO.getStarRating());
        }
        return entity;
    }

    public PageDTO<HotelDTO> pageEntityToPageDTO(Page<Hotel> entityPage) {
        PageDTO<HotelDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(entityListToDTOList(entityPage.getContent()));
        pageDTO.setTotalPages(entityPage.getTotalPages());
        pageDTO.setTotalElements(entityPage.getTotalElements());
        pageDTO.setCurrentPage(entityPage.getNumber());
        pageDTO.setSize(entityPage.getSize());
        return pageDTO;
    }
}
