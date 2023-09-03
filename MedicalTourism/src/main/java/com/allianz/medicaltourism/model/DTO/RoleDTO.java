package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.util.Set;


@Data
public class RoleDTO extends BaseDTO {
	private String name;
	private String description;

	public RoleDTO() {
	}
}