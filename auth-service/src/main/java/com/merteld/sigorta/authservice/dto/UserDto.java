package com.merteld.sigorta.authservice.dto;

import com.merteld.sigorta.authservice.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private Role role;
}
