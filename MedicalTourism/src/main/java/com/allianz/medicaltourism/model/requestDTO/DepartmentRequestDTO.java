package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

@Data
public class DepartmentRequestDTO extends BaseDTO {

	private String name;

	private String description;
}
