package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.model.responseDTO.PersonResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import com.allianz.healthtourism.util.security.UserEntity;
import com.allianz.healthtourism.util.security.UserResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class DoctorPlainResponseDTO extends PersonResponseDTO {
    private UserPlainResponseDTO user;
}
