package com.merteld.sigorta.userservice.controller;

import com.merteld.sigorta.userservice.dto.AuthUserDto;
import com.merteld.sigorta.userservice.dto.RegisterDto;
import com.merteld.sigorta.userservice.dto.UserDto;
import com.merteld.sigorta.userservice.dto.UserInfoDto;
import com.merteld.sigorta.userservice.model.User;
import com.merteld.sigorta.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/getUserByUsername/{username}")
    public ResponseEntity<AuthUserDto> getUserByUsername(@PathVariable String username) {
        AuthUserDto authUserDto = userService.getUserByUsername(username);

        return ResponseEntity.ok(authUserDto);
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@RequestBody RegisterDto request) {

        return ResponseEntity.ok(userService.save(request));
    }

    @GetMapping("/details")
    public ResponseEntity<UserInfoDto> getUserDetails(Authentication authentication) {

        User user = userService.getUserById(Long.valueOf(authentication.getName()));
        return ResponseEntity.ok(UserInfoDto.toDto(user));


    }




}
