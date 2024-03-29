package com.matrimony.repository;

import com.matrimony.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    Optional<User> findById(String email);

}
