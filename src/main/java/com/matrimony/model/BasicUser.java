package com.matrimony.model;

import lombok.Data;

@Data
public class BasicUser {

    private String id;

    private String fullName;

    private String email;

    private Boolean emailVerified;

    private String phone;

    private Boolean phoneVerified;

    private String gender;

    private String profileFor;

    private Boolean isActive;

    private Boolean isVerified;

    private String verifiedBy;

    private Boolean isEnabled;

    private String dob;

    private String religion;

    private String cast;

    private String subCast;

    private String branchId;

    private String password;


}
