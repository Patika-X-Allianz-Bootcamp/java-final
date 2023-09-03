package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.util.Set;


@Data
public class RoleRequestDTO extends BaseDTO {
	private String name;
	private String description;

	public RoleRequestDTO() {
	}
}