package com.merteld.sigorta.userservice.controller;

import com.merteld.sigorta.userservice.dto.AuthUserDto;
import com.merteld.sigorta.userservice.dto.RegisterDto;
import com.merteld.sigorta.userservice.dto.UserDto;
import com.merteld.sigorta.userservice.model.User;
import com.merteld.sigorta.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserByUsername/{username}")
    public ResponseEntity<AuthUserDto> getUserByUsername(@PathVariable String username) {
        AuthUserDto authUserDto = userService.getUserByUsername(username);

        return ResponseEntity.ok(authUserDto);
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@RequestBody RegisterDto request) {

        return ResponseEntity.ok(userService.save(request));
    }




}
