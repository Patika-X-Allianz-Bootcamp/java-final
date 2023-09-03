package com.allianz.patienttourism.util.security;


import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

@Data
public class RoleRequestDTO extends BaseRequestDTO {
    private String name;
}
