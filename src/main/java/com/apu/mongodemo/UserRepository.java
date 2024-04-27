package com.apu.mongodemo;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query(value="{'name': ?0}")
    List<User> findByName(String name);

    @Aggregation(pipeline = "{$match: {'company.title' : {$eq: ?0}}}")
    List<User> findByCompanyTitle(String companyTitle);

}
