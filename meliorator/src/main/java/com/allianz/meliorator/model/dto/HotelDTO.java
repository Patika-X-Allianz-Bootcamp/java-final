package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.database.entity.Room;
import com.allianz.meliorator.model.enums.ClassTypeEnum;
import com.allianz.meliorator.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class HotelDTO extends BaseDTO {
    private String name;
    private int star;
    private ClassTypeEnum classTypeEnum;

    private List<Room> room;
}
