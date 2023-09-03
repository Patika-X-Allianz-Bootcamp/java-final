package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.model.DoctorDTO;
import com.example.healthtourismapp.model.PatientDTO;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.util.Date;

@Data
public class ReportRequestDTO extends BaseDTO {

    private DoctorDTO doctor;
    private PatientDTO patient;
    private String content;
    private Date date;;
}
