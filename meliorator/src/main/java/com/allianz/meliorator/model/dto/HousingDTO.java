package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.database.entity.Person;
import com.allianz.meliorator.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class HousingDTO extends BaseDTO {
    private List<Person> person;
    private int bodyCount;
    private boolean isApproved;
}
