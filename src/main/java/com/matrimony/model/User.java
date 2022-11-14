package com.matrimony.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "profile_user")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BasicUser {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private String id;

    private Date createdAt;

    private Date updatedAt;
}
