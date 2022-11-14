package com.matrimony.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matrimony.model.BasicBranch;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchCreateRequestDto extends BasicBranch {

    private String createdBy;

    private Date createdOn;

}
