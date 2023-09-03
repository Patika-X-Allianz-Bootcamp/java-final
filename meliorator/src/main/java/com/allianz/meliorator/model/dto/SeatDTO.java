package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
@Data
public class SeatDTO extends BaseDTO {
    private HashSet<String> seatSet = new HashSet<>();
}
