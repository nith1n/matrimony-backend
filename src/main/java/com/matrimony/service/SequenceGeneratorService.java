package com.matrimony.service;

import com.matrimony.model.DbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {

    @Autowired
    MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName) {
        //get sequence number
        Query query = new Query(Criteria.where("id").is(sequenceName));

        //update sequence number
        Update update = new Update().inc("seqNo", 1);

        //modify sequence number in database
        DbSequence counter = mongoOperations
                .findAndModify(query, update, options().returnNew(true).upsert(true),
                        DbSequence.class);
        return !Objects.isNull(counter) ? counter.getSeqNo() : 2;

    }
}
