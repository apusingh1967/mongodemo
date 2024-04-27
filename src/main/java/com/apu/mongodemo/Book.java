package com.apu.mongodemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Document
public class Book {

    @Id Integer id;
    private String titleString;
    @Field("author_id") private String authorId;
    private String genre;

}
