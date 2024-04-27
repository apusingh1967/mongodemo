package com.apu.mongodemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
public class UserTest {

    @Autowired private MongoTemplate template;
    @Autowired private UserRepository repository;

    @Test
	void contextLoads() {
	}

    @Test public void simpleQuery(){
        System.out.println(repository.findById("66258960ebec04085e06249b"));
    }

    @Test public void findByName() {
        System.out.println(repository.findByName("Aurelia Gonzales"));
    }

    @Test public void findByCompanyTitle() {
        System.out.println(repository.findByCompanyTitle("EXIAND"));
    }

}
