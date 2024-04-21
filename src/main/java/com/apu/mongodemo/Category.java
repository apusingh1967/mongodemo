package com.apu.mongodemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @AllArgsConstructor @Builder @Document
public class Category {

    @Id private String id;
    private String name;
    private String description;

}
