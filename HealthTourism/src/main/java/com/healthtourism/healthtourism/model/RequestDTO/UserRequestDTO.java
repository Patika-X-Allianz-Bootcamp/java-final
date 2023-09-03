package com.healthtourism.healthtourism.model.RequestDTO;

import com.healthtourism.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class UserRequestDTO extends BaseDTO {


        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private Long roleId;
}
