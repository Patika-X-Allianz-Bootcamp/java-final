package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SelectDoctorRequestDTO extends BaseDTO {
    private DoctorRequestDTO doctor;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;
}
