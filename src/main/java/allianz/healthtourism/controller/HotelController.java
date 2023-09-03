package allianz.healthtourism.controller;

import allianz.healthtourism.base.BaseController;
import allianz.healthtourism.dto.Request.HotelRequest;
import allianz.healthtourism.dto.Response.HotelDTO;
import allianz.healthtourism.entity.Hotel;
import allianz.healthtourism.repository.HotelRepository;
import allianz.healthtourism.service.HotelService;
import allianz.healthtourism.specification.HotelSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<
        Hotel,
        HotelDTO,
        HotelRequest,
        HotelRepository,
        HotelSpecification,
        HotelService> {


    @Autowired
    HotelService hotelService;


    @Override
    protected HotelService getService() {
        return hotelService;
    }
}
