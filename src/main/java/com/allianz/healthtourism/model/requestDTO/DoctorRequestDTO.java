package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import com.allianz.healthtourism.util.security.UserEntity;
import com.allianz.healthtourism.util.security.UserRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class DoctorRequestDTO extends BaseRequestDTO {
    private Long hospitalId;
    private Long healthCareServiceId;
    private UserRequestDTO user;
}
