package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.database.entity.Users;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;
import java.util.List;
@Data
public class RoleRequestDTO extends BaseRequestDTO {
    private String name;
    private String description;
    private List<UsersRequestDTO> users;
}
