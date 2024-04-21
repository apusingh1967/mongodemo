package com.apu.mongodemo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Document @Data @AllArgsConstructor @Builder
public class Product {
    @Id private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private Integer rating;
    private List<String>tags;
    @DBRef private Category category;
}
