package Tourism.model;


import Tourism.model.enums.SexEnum;
import Tourism.model.enums.TitleEnum;
import Tourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class DoctorDTO extends BaseDTO {

    private String name;
    private String surname;
    private int age;
    private String expertise;
    private TitleEnum title;
    private SexEnum sex;
    private boolean isOperationDay;
    private int appointmentCapacity; //needs to be dynamitasied.
    private HospitalDTO hospital;
    private List<AppointmentDTO> appointmentList;


}
