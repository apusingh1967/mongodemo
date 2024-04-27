package com.apu.mongodemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryTest {

    @Autowired private QueryRepository repository;

    @Test public void findByUser() {
        var us = repository.findUsersBy(30, false, "blue");
        for(var u: us){
            System.out.println(u.getEyeColor() + ", " + u.isActive() + ", " + u.getAge());
        }
    }

}
