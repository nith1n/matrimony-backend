package com.matrimony.service;

import com.matrimony.security.util.JwtUtil;
import com.matrimony.dto.UserAuthenticationRequestDto;
import com.matrimony.dto.UserAuthenticationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public UserAuthenticationResponseDto userLogin(UserAuthenticationRequestDto authenticationRequestDto)
            throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequestDto.getUsername(),
                            authenticationRequestDto.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails
                = userDetailsService.loadUserByUsername(authenticationRequestDto.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);


        return new UserAuthenticationResponseDto(jwt);

    }
}
