package allianz.healthtourism.dto.Request;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;
}
