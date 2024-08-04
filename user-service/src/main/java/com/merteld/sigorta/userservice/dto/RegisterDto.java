package com.merteld.sigorta.userservice.dto;

import com.merteld.sigorta.userservice.model.Role;
import lombok.Data;

@Data
public class RegisterDto {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private Role role;

}
