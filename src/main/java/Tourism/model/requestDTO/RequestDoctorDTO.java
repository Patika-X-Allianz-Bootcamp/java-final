package Tourism.model.requestDTO;


import Tourism.model.enums.SexEnum;
import Tourism.model.enums.TitleEnum;
import Tourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class RequestDoctorDTO extends BaseDTO {

    private String name;
    private String surname;
    private int age;
    private String expertise;
    private SexEnum sex;
    private TitleEnum title;
    private boolean isOperationDay;
    private int appointmentCapacity; //needs to be dynamitasied.
    private RequestHospitalDTO hospital;
    private List<RequestAppointmentDTO> appointmentList;


}
