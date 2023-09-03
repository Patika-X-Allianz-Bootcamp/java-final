package Tourism.model;


import Tourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO extends BaseDTO {


    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String website;
    private String description;
    private int numberOfBeds;
    private int numberOfDoctors;
    private List<String> clinics;
    private List<PatientDTO> patientList;
    private List<DoctorDTO> doctorList;



}
