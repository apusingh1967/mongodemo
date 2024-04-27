package com.apu.mongodemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Document(collection = "authors") @NoArgsConstructor
public class Author {

    @Id private int id;
    private String name;
    @Field("birth_year")
    private int birthYear;

}
