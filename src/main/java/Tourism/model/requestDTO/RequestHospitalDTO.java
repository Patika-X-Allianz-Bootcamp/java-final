package Tourism.model.requestDTO;


import Tourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class RequestHospitalDTO extends BaseDTO {


    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String website;
    private String description;
    private int numberOfBeds;
    private int numberOfDoctors;
    private List<String> clinics;
    private List<RequestPatientDTO> patientList;
    private List<RequestDoctorDTO> doctorList;



}
