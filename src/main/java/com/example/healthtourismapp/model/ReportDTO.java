package com.example.healthtourismapp.model;

import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.util.Date;

@Data
public class ReportDTO extends BaseDTO {

    private DoctorDTO doctor;
    private PatientDTO patient;
    private String content;
    private Date date;;
}
