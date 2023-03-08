package com.matrimony.controller;

import com.matrimony.dto.UserAuthenticationRequestDto;
import com.matrimony.dto.UserAuthenticationResponseDto;
import com.matrimony.dto.UserRegistrationRequestDto;
import com.matrimony.model.User;
import com.matrimony.service.MyUserDetailsService;
import com.matrimony.service.UserLoginService;
import com.matrimony.service.UserRegistrationService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/auth")
public class UserAuthController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService userDetailsService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    public ResponseEntity<UserAuthenticationResponseDto> loginUser(
            @RequestBody UserAuthenticationRequestDto authenticationRequestDto) throws Exception {
        UserAuthenticationResponseDto responseDto = userLoginService.userLogin(authenticationRequestDto);
        log.debug("User token granted to the user : " + authenticationRequestDto.getUsername());
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/register")
    public ResponseEntity<User> newUserRegistration(
            @Valid @RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {
        return ResponseEntity.ok(userRegistrationService.createUser(userRegistrationRequestDto));
    }
}
