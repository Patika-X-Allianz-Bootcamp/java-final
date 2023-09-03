package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.util.BaseResponseDTO;
import com.allianz.healthtourism.util.security.UserResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class PatientWithExaminationRecordResponseDTO extends PersonResponseDTO {
    private UserResponseDTO user;
    private List<ExaminationRecordResponseDTO> examinationRecords;
}
