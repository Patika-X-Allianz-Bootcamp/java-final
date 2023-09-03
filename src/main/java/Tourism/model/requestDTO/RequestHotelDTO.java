package Tourism.model.requestDTO;


import Tourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class RequestHotelDTO extends BaseDTO {

    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String website;
    private int starRating;
    private int roomCapacity;
    private boolean isPetFriendly;
    private String description;
    private List<RequestPatientDTO> patientList;



}
