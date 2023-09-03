package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import com.allianz.healthtourism.util.dbutil.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class RoomRequestDTO extends BaseRequestDTO {
    private int roomNo;
}
