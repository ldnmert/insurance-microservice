package com.merteld.sigorta.userservice.dto;

import com.merteld.sigorta.userservice.model.User;
import lombok.Data;

@Data
public class UserInfoDto {

    private String firstName;
    private String lastName;
    private String photo;

    public static UserInfoDto toDto(User user){
        UserInfoDto dto = new UserInfoDto();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhoto(user.getPhoto());
        return dto;
    }
}
