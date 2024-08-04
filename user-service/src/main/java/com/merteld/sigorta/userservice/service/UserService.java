package com.merteld.sigorta.userservice.service;

import com.merteld.sigorta.userservice.dto.AuthUserDto;
import com.merteld.sigorta.userservice.dto.RegisterDto;
import com.merteld.sigorta.userservice.dto.UserDto;
import com.merteld.sigorta.userservice.model.User;
import com.merteld.sigorta.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public AuthUserDto getUserByUsername(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(NoSuchElementException::new);

        return AuthUserDto.toDto(user);
    }

    public UserDto save (RegisterDto user){
        User saveUser = new User();

        saveUser.setUsername(user.getUsername());
        saveUser.setPassword(passwordEncoder.encode(user.getPassword()));
        saveUser.setEmail(user.getEmail());
        saveUser.setFirstName(user.getFirstName());
        saveUser.setLastName(user.getLastName());
        saveUser.setPhone(user.getPhone());
        saveUser.setRole(user.getRole());

       User savedUser = userRepository.save(saveUser);
        return UserDto.toDto(savedUser);
    }
}
