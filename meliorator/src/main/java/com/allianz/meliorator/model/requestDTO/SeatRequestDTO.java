package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

import java.util.HashSet;
@Data
public class SeatRequestDTO extends BaseRequestDTO {
    private HashSet<String> seatSet = new HashSet<>();
}
