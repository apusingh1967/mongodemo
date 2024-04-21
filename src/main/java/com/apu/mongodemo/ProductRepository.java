package com.apu.mongodemo;

import org.springframework.data.mongodb.repository.*;;

public interface ProductRepository extends MongoRepository<Product, String> {

}
