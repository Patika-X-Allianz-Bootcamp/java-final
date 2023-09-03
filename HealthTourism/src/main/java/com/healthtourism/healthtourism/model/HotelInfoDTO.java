package com.healthtourism.healthtourism.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class HotelInfoDTO extends BaseDTO {

    private String hotelName;
    private String city;
    private String roomTypesAndPrices;
    private String reservationStatus;
    private PatientDTO patient;

}
