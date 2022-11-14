package com.matrimony.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matrimony.model.BasicBranch;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "branch")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch extends BasicBranch {

    @Transient
    public static final String SEQUENCE_NAME = "branch_sequence";

    private String createdBy;

    private Date createdOn;

    private String approvedBy;

    private Date approvedOn;

    private Date updatedOn;


}
