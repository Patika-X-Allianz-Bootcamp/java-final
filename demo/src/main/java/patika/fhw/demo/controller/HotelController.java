package patika.fhw.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import patika.fhw.demo.database.entity.Hotel;
import patika.fhw.demo.database.repository.HotelRepository;
import patika.fhw.demo.database.specification.HotelSpecification;
import patika.fhw.demo.mapper.HotelMapper;
import patika.fhw.demo.model.dto.HotelDTO;
import patika.fhw.demo.model.requestDTO.HotelRequestDTO;
import patika.fhw.demo.service.HotelService;
import patika.fhw.demo.util.BaseController;

@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<
        Hotel,
        HotelDTO,
        HotelRequestDTO,
        HotelMapper,
        HotelRepository,
        HotelSpecification,
        HotelService> {

    @Autowired
    private HotelService hotelService;

    @Override
    protected HotelService getService() {
        return hotelService;
    }
}
