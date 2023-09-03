package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequestDTO extends BaseDTO {

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private boolean isEnable;


    /*@JoinTable(name = "user_group",joinColumns = @JoinColumn(name="user_id"))
    @JoinColumn(name = "group_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Group> group;*/
    private Set<RoleRequestDTO> roles;


    public UserRequestDTO() {
        isEnable = false;
    }
    }
