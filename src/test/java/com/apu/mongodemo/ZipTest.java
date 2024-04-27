package com.apu.mongodemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ZipTest {

    @Autowired private ZipRepository repository;

    // @Test public void findById() {
    //     System.out.println(repository.findById("01020"));
    // }

    // @Test public void popGpByState() {
    //     System.out.println(repository.findPopByState(10000000));
    // }

    // @Test public void avgPopByState() {
    //     for(var r: repository.findAvgPopByState()){
    //         System.out.println(r);
    //     };
    // }

    @Test public void findMinMx() {
        System.out.println(repository.findMinMxPop());
    }

}
