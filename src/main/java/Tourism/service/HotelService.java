package Tourism.service;

import Tourism.database.entity.HotelEntity;
import Tourism.database.repository.HotelRepository;
import Tourism.database.specification.HotelSpecification;
import Tourism.mapper.HotelMapper;
import Tourism.model.HotelDTO;
import Tourism.model.requestDTO.RequestHotelDTO;
import Tourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends BaseService<HotelEntity, HotelDTO, RequestHotelDTO,
        HotelMapper, HotelRepository, HotelSpecification> {

    @Autowired
    HotelMapper hotelMapper;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelSpecification hotelSpecification;

    @Override
    protected HotelMapper getMapper() {
        return hotelMapper;
    }

    @Override
    protected HotelRepository getRepository() {
        return hotelRepository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return hotelSpecification;
    }
}
