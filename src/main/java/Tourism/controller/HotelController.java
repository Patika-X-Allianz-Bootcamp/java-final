package Tourism.controller;

import Tourism.database.entity.HotelEntity;
import Tourism.database.repository.HotelRepository;
import Tourism.database.specification.HotelSpecification;
import Tourism.mapper.HotelMapper;
import Tourism.model.HotelDTO;
import Tourism.model.requestDTO.RequestHotelDTO;
import Tourism.service.HotelService;
import Tourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<
        HotelEntity,
        HotelDTO,
        RequestHotelDTO,
        HotelMapper ,
        HotelRepository,
        HotelSpecification,
        HotelService> {

    @Autowired
    HotelService hotelService;

    @Override
    protected HotelService getService() {
        return this.hotelService;
    }
}