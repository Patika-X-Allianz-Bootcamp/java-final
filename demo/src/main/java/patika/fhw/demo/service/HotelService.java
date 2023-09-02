package patika.fhw.demo.service;

import org.springframework.stereotype.Service;

import patika.fhw.demo.database.entity.Hotel;
import patika.fhw.demo.database.repository.HotelRepository;
import patika.fhw.demo.database.specification.HotelSpecification;
import patika.fhw.demo.mapper.HotelMapper;
import patika.fhw.demo.model.dto.HotelDTO;
import patika.fhw.demo.model.requestDTO.HotelRequestDTO;
import patika.fhw.demo.util.BaseService;

@Service
public class HotelService extends BaseService<Hotel, HotelDTO, HotelRequestDTO, HotelMapper, HotelRepository, HotelSpecification> {

    private final HotelMapper mapper;
    private final HotelRepository repository;
    private final HotelSpecification specification;

    public HotelService(HotelMapper mapper, HotelRepository repository, HotelSpecification specification) {
        this.mapper = mapper;
        this.repository = repository;
        this.specification = specification;
    }

    @Override
    protected HotelMapper getMapper() {
        return mapper;
    }

    @Override
    protected HotelRepository getRepository() {
        return repository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return specification;
    }
}
