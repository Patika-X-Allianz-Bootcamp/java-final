package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.HotelEntity;
import com.allianz.healthtourismagency.database.repository.HotelRepository;
import com.allianz.healthtourismagency.database.specification.HotelSpecification;
import com.allianz.healthtourismagency.mapper.HotelMapper;
import com.allianz.healthtourismagency.mapper.HotelReservationMapper;
import com.allianz.healthtourismagency.model.HotelDTO;
import com.allianz.healthtourismagency.model.RoomDTO;
import com.allianz.healthtourismagency.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.HotelReservationRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class HotelService extends BaseService<HotelEntity, HotelDTO, HotelRequestDTO, HotelMapper, HotelRepository,
        HotelSpecification> {

    private final HotelMapper hotelMapper;
    private final HotelRepository hotelRepository;
    private final HotelSpecification hotelSpecification;
    private final RoomService roomService;
    private final HotelReservationMapper hotelReservationMapper;

    public HotelService(HotelMapper hotelMapper, HotelRepository hotelRepository, HotelSpecification hotelSpecification, RoomService roomService, HotelReservationMapper hotelReservationMapper) {
        this.hotelMapper = hotelMapper;
        this.hotelRepository = hotelRepository;
        this.hotelSpecification = hotelSpecification;
        this.roomService = roomService;
        this.hotelReservationMapper = hotelReservationMapper;
    }


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

    @Override
    public HotelDTO save(HotelRequestDTO hotelRequestDTO) {
        hotelRequestDTO.setRoomList(null);

        HotelDTO hotelDTO = hotelMapper.entityToDto(hotelMapper.requestDtoToEntity(hotelRequestDTO));
        addRoomListToHotel(hotelDTO);

        hotelRepository.save(hotelMapper.dtoToEntity(hotelDTO));
        return hotelDTO;
    }

    public void addRoomListToHotel(HotelDTO hotelDTO) {
        List<RoomDTO> roomList = new ArrayList<>();
        for (int roomNumber = 1; roomNumber <= hotelDTO.getCapacity(); roomNumber++) {
            RoomDTO room = new RoomDTO();
            room.setRoomNumber(roomNumber);
            room.setReservationList(null);
            roomList.add(room);
        }
        hotelDTO.setRoomList(roomList);
    }

    public RoomDTO selectRandomRoom(HotelDTO hotelDTO, HotelReservationRequestDTO hotelReservationRequestDTO) {
        List<RoomDTO> availableRooms = hotelDTO.getRoomList();
        List<RoomDTO> availableRoomsCopy = new ArrayList<>(availableRooms);

        Iterator<RoomDTO> iterator = availableRoomsCopy.iterator();
        while (iterator.hasNext()) {
            RoomDTO room = iterator.next();
            if (!roomService.isRoomAvailable(room.getReservationList(), hotelReservationRequestDTO)) {
                iterator.remove();
            }
        }

        if (availableRoomsCopy.isEmpty()) {
            throw new IllegalStateException("No available rooms in this hotel.");
        }

        Random randomRoom = new Random();
        int selectedIndex = randomRoom.nextInt(availableRoomsCopy.size());
        RoomDTO selectedRoom = availableRoomsCopy.get(selectedIndex);

        selectedRoom.getReservationList().add(hotelReservationMapper.entityToDto(hotelReservationMapper.requestDtoToEntity(hotelReservationRequestDTO)));
        return selectedRoom;
    }
}
