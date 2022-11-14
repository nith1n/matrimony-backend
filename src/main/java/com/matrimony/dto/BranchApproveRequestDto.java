package com.matrimony.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BranchApproveRequestDto {

    private String branchNo;

    private String approvedBy;

    private Date approvedOn;

}
