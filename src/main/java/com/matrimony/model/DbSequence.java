package com.matrimony.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequence")
@Data
public class DbSequence {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private String id;

    private int seqNo;
}
