package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.database.entity.Person;
import com.allianz.meliorator.util.BaseRequestDTO;

import java.util.List;

public class HousingRequestDTO extends BaseRequestDTO {
    private List<Person> person;
    private int bodyCount;
    private boolean isApproved;
}
