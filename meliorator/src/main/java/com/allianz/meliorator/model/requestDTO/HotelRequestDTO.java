package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.database.entity.Room;
import com.allianz.meliorator.model.enums.ClassTypeEnum;
import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelRequestDTO extends BaseRequestDTO {
    private String name;
    private int star;
    private ClassTypeEnum classTypeEnum;
    private List<Room> room;
}
