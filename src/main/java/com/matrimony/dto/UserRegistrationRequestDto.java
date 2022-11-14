package com.matrimony.dto;

import com.matrimony.model.BasicUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRegistrationRequestDto extends BasicUser {

    private static final String ALPHANUMERIC = "[a-zA-Z0-9]";
    private static final String ALPHA = "[a-zA-Z]";

    private String id;

    @NotBlank
    @Pattern(regexp = "[\\W\\w]{1,40}")
    private String fullName;

    @NotBlank
    @Pattern(regexp = "(^" + ALPHANUMERIC + "[\\w.+%-]{2,63}@" + ALPHANUMERIC + "{2,63}((\\." + ALPHA + "{2,63})$|(\\."
            + ALPHA + "{2,63}." + ALPHA + "{2,63})$))|(\\s*)", message = "Invalid email")
    private String email;

    @Pattern(regexp = "\\d*")
    private String phone;

    @NotBlank
    private String gender;

    @NotBlank
    private String dob;

    @NotBlank
    private String profileFor;

    private String branchNo;

    @NotBlank
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[\\W])(?=.*\\d).{8,50}$)", message = "Invalid password format")
    private String password;


}
