package com.merteld.sigorta.userservice.dto;

import com.merteld.sigorta.userservice.model.Role;
import com.merteld.sigorta.userservice.model.User;
import lombok.Data;

@Data
public class AuthUserDto {
    private Long id;
    private String username;
    private String password;
    private Role role;

    public static AuthUserDto toDto(User user) {

        AuthUserDto authUserDto = new AuthUserDto();
        authUserDto.setId(user.getId());
        authUserDto.setUsername(user.getUsername());
        authUserDto.setPassword(user.getPassword());
        authUserDto.setRole(user.getRole());

        return authUserDto;


    }
}