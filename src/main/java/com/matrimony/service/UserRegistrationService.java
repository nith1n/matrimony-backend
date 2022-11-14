package com.matrimony.service;

import com.matrimony.service.SequenceGeneratorService;
import com.matrimony.dto.UserRegistrationRequestDto;
import com.matrimony.model.User;
import com.matrimony.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserRegistrationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SequenceGeneratorService service;


    public User createUser(UserRegistrationRequestDto userRegistrationRequestDto) {

        User user = new User();

        int seqId = service.getSequenceNumber(User.SEQUENCE_NAME);
        user.setId("DM22USR0" + seqId);
        user.setProfileFor(userRegistrationRequestDto.getProfileFor());
        user.setFullName(userRegistrationRequestDto.getFullName());

        user.setEmail(userRegistrationRequestDto.getEmail());
        user.setEmailVerified(false);

        user.setPhone(userRegistrationRequestDto.getPhone());
        user.setPhoneVerified(false);

        user.setPassword(userRegistrationRequestDto.getPassword());

        user.setGender(userRegistrationRequestDto.getGender());

        user.setReligion(userRegistrationRequestDto.getReligion());
        user.setCast(userRegistrationRequestDto.getCast());
        user.setSubCast(userRegistrationRequestDto.getSubCast());

        user.setDob(userRegistrationRequestDto.getDob());
        user.setBranchId(userRegistrationRequestDto.getBranchId());

        user.setIsActive(false);
        user.setIsEnabled(false);
        user.setIsVerified(false);
        user.setVerifiedBy(null);

        user.setCreatedAt(new Date());
        user.setUpdatedAt(user.getCreatedAt());


        return userRepository.insert(user);

    }

}
