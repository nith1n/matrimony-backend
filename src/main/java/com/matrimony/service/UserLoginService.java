package com.matrimony.service;

import com.matrimony.dto.UserAuthenticationRequestDto;
import com.matrimony.dto.UserAuthenticationResponseDto;

public interface UserLoginService {

    UserAuthenticationResponseDto userLogin(UserAuthenticationRequestDto userAuthenticationRequestDto) throws Exception;
}
